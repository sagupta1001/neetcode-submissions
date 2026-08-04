class Solution {
    // problem
    // find minimum number of cpu cycles required to complete
    // all tasks

    // approach
    // at any point in time
    // need to know what was the last picked task
    // and the available tasks
    // available tasks need to be in a hash map
    // task name -> freq count
    
    // need to know 

    // max heap -> what can i run now
    // queue -> cooldown 
    // current time -> cpu counter

    // pseudo code:
    // initialize the task to freq map
    // a: 3, b: 1, c: 1
    
    // initialize a max heap
    // highest freq task will be root

    // stores: (task, remainingFreq, availableTime)

    // initialize time counter to zero
    // loop while queue not empty or heap not empty:
    // - increment time
    // - move tasks from queue to max heap
    // - if heap not empty
    // - - put task
    // - - decrement freq
    // - - if freq > 0
    // - - - put in cooldown queue
    // - else
    // - - put idle

    class Task {
        char task;
        int freq;

        Task(char task, int freq) {
            this.task = task;
            this.freq = freq;
        }
    }

    class CooldownTask {
        Task task;
        int availableTime;

        CooldownTask(Task task, int availableTime) {
            this.task = task;
            this.availableTime = availableTime;
        }

    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> taskFreq = new HashMap<>();

        for (char t : tasks) {
            taskFreq.put(t, taskFreq.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        Queue<CooldownTask> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : taskFreq.entrySet()) {
            maxHeap.offer(new Task(entry.getKey(), entry.getValue()));
        }

        int time = 0;

        while (queue.size() != 0 || maxHeap.size() != 0) {
            time++;

            while (queue.size() != 0 && queue.peek().availableTime == time) {
                CooldownTask ready = queue.poll();
                maxHeap.offer(ready.task);
            }

            if (maxHeap.size() != 0) {
                Task current = maxHeap.poll();
                current.freq--;

                if (current.freq > 0) {
                    queue.offer(new CooldownTask(current, time + n + 1));
                }
            }
        }

        return time;
    }
}
