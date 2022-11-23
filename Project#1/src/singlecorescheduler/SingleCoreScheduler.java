package singlecorescheduler;

/**
 * A application to simulate a non-preemptive scheduler for a single-core CPU
 * using a heap-based implementation of a priority queue
 * @author William Duncan, Dylan Scivicque
 * @see PQueue.java, PCB.java
 * <pre>
 * DATE: 9/21/2022
 * File:SingleCoreScheduler.java
 * Course: csc 3102
 * Programming Project # 1
 * Instructor: Dr. Duncan
 * Usage: SingleCoreScheduler <number of cylces> <-R or -r> <probability of a  process being created per cycle>  or,
 *        SingleCoreScheduler <number of cylces> <-F or -f> <file name of file containing processes>,
 *        The simulator runs in either random (-R or -r) or file (-F or -f) mode 
 * </pre>
 */


import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class SingleCoreScheduler
{
    /**
     * Single-core processor with non-preemptive scheduling simulator    
     * @param args an array of strings containing command line arguments
     * args[0] - number of cyles to run the simulation
     * args[1] - the mode: -r or -R for random mode and -f or -F for file mode
     * args[2] - if the mode is random, this entry contains the probability that
     * a process is created per cycle and if the simulator is running in
     *           file mode, this entry contains the name of the file containing the 
     *           the simulated jobs. In file mode, each line of the input file is  
     *           in this format: 
     * <process ID> <priority value> <cycle of process creation> <time required to execute> 
     */
    public static void main(String []args) throws PQueueException, IOException
    {
        if (args.length != 3)
        {
            System.out.println("Usage: SingleCoreScheduler <number of cylces> <-R or -r> <probability of a  process being created per cycle>  or ");
            System.out.println("       SingleCoreScheduler <number of cylces> <-F or -f> <file name of file containing processes>");
            System.out.println("The simulator runs in either random (-R or -r) or file (-F or -f) mode.");
            System.exit(1);
        }
        
        Comparator<PCB> cmp = (x,y) ->
        {
            if (x.isExecuting()) return 1;
            if (y.isExecuting()) return -1;
            if (x.getPriority() > y.getPriority()) return 1;
            if (x.getPriority() < y.getPriority()) return -1;
            if (x.getArrival() > y.getArrival()) return 1;
            if (x.getArrival() < y.getArrival()) return -1;
            return 0;
        };
        
        PQueue<PCB> readyQ = new PQueue(cmp);
        
        Scanner sc = new Scanner(new FileReader("src\\SimulatedJobs.txt"));
        int cycles = Integer.parseInt(args[0]);
        int pid = 1;
        int waitTime = 0;
        int processComplete = 0;
        double turnaroundTime = 0;
        PCB pcb = null;
        String prob = args[2];
        Random numGenerator = new Random(System.currentTimeMillis());

        for (int i = 0; i <= cycles; i++)
        {
                System.out.println("***Cycle #: " + i + " ***");
                if (readyQ.isEmpty())
                {
                    System.out.println("The CPU is idle.");
                }
                
                else
                {
                    
                    if (!readyQ.peek().isExecuting())
                    {
                        readyQ.peek().execute();
                        readyQ.peek().setStart(i);
                        int startTime = readyQ.peek().getStart();
                        int arrivalTime = readyQ.peek().getArrival();
                        readyQ.peek().setWait(startTime - arrivalTime);
                    }
                    
                    if (i == readyQ.peek().getBurst() + readyQ.peek().getStart())
                    {
                        turnaroundTime = waitTime + readyQ.peek().getBurst();
                        waitTime = waitTime + readyQ.peek().getWait();
                        System.out.println("Prcoess # " + readyQ.peek().getPid() + " has just terminated");
                        processComplete++;
                        readyQ.remove();
                    }
                    
                    else
                    {
                        System.out.println("Process # " + readyQ.peek().getPid() + " is executing.");
                    }
                    
                }

                if (numGenerator.nextDouble() <= Double.parseDouble(prob))
                {
                    pcb = new PCB(pid, numGenerator.nextInt(40)-19, 0, i, numGenerator.nextInt(100));
                    waitTime++;
                    readyQ.insert(pcb);
                    System.out.println("Adding a job with pid #" + pid + " and priority " + readyQ.peek().getPriority() + " and burst " + readyQ.peek().getBurst());
                    pid++;
                }
                
                else
                {
                    System.out.println("No new job this cycle.");
                }

        }

        sc.close();
        
        System.out.println("The average number of process created per cycle is " + (double) (processComplete)/(cycles) + ".");
        System.out.println("The average turnaround time per process is " + turnaroundTime + ".");
        System.out.println("The average wait time per process is " + (double) (waitTime)/(processComplete) + ".");
        
    }
    
}
