class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        //initialize and construct map
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < seqs.size(); i++) {
            List<Integer> list = seqs.get(i);
            if(list.size() == 1) {
                if(!map.containsKey(list.get(0))) {
                    map.put(list.get(0), new ArrayList<>());
                }
                continue;
            }
            for(int j = 0; j < list.size() - 1; j++) {
                int node = list.get(j);
                int next = list.get(j + 1);
                if(!map.containsKey(node)) {
                    map.put(node, new ArrayList<Integer>());
                }
                if(!map.containsKey(next)) {
                    map.put(next, new ArrayList<Integer>());
                }
                map.get(node).add(next);
            }
        }
        if(map.size() != org.length) {
            return false;
        }
        //initialize inCount
        Map<Integer, Integer> inCount = new HashMap<Integer, Integer>();
        for(int i = 0; i < org.length; i++) {
            inCount.put(org[i], 0);
        }
        //construct inCount
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int node = entry.getKey();
            List<Integer> neighbors = entry.getValue();
            for(int neighbor : neighbors) {
                inCount.put(neighbor, inCount.get(neighbor) + 1);
            }
        }
        //initialize queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int key : inCount.keySet()) {
            if(inCount.get(key) == 0) {
                queue.offer(key);
            }
        }
        //BFS
        int count = 0;
        while(!queue.isEmpty()) {
            if(queue.size() > 1) {
                return false;
            }
            int node = queue.poll();
            if(org[count] != node) {
                return false;
            }
            count++;
            List<Integer> neighbors = map.get(node);
            for(int neighbor : neighbors) {
                inCount.put(neighbor, inCount.get(neighbor) - 1);
                if(inCount.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if(count != org.length) {
            return false;
        } else {
            return true;
        }
    }
}
