import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolApp {

    public static void main(String[] args) {
        // Check if the user provided enough arguments
        if (args.length < 2) {
            // Call the error method if arguments are insufficient
            ThreadPoolApp.error();
        }
        try {
            // Parse the first argument as the number of jobs
            int numberOfJobs = Integer.parseInt(args[0]);
            // Parse the second argument as the number of threads in the pool
            int numberOfThreads = Integer.parseInt(args[1]);

            // Validate that both values are positive
            if (numberOfJobs < 1 || numberOfThreads < 1) {
                ThreadPoolApp.error();
            }

            // Create a thread pool with the specified number of threads
            ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);

            // Create an array to hold the job instances
            Job[] jobs = new Job[numberOfJobs];

            // Initialize and execute each job using the thread pool
            for (int i = 0; i < numberOfJobs; i++) {
                jobs[i] = new Job(i);  // Create a new job with a job number
                pool.execute(jobs[i]); // Submit the job to the thread pool for execution
            }

            // Shutdown the thread pool after submitting all jobs
            pool.shutdown(); // Prevent new tasks from being submitted, but allow existing tasks to finish

            // Print a message from the main thread (for debugging/logging purposes)
            System.out.println("Last line " + Thread.currentThread().getName());

        } catch (NumberFormatException e) {
            // If the arguments can't be parsed as integers, call the error method
            ThreadPoolApp.error();
        }
    }

    /**
     * Prints an error message and exits the program.
     * This method is called when the program does not receive
     * valid inputs (positive integer values for jobs and threads).
     */
    private static void error() {
        // Print a message describing the proper usage of the program
        System.out.println("ThreadPoolApp must be run with two positive valued " +
                           "integer arguments. The first detailing the number of jobs " +
                           "the second the number of processing threads in the pool");

        // Exit the program with status code 0 (indicating normal termination)
        System.exit(0);
    }
}