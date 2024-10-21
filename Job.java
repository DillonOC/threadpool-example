/**
 * The Job class implements the Runnable interface.
 * Each job has a job number and is processed by a thread.
 */
public class Job implements Runnable {
    private int jobNumber;

    /**
     * Constructor to create a Job with a specific job number.
     *
     * @param jobNumber The number assigned to this job.
     */
    Job(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    /**
     * The run method processes the job by simulating work (sleeping).
     * It prints the current thread name before and after the work is done.
     */
    public void run() {
        System.out.println("Job: " + jobNumber + " is being processed by thread: " 
                            + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // No handling required for this example
        }
        System.out.println("Job: " + jobNumber + " is ending in thread: " 
                            + Thread.currentThread().getName());
    }
}
