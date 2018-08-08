    // Hash Tables: Ransom Note
    // https://www.hackerrank.com/challenges/ctci-ransom-note/problem
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> magazineMap = new HashMap();
        for (String s : magazine) {
            if (magazineMap.containsKey(s)) {
                Integer newValue = magazineMap.get(s) + 1;
                magazineMap.put(s, newValue);
            }
            else {
                magazineMap.put(s, 1);
            }
        }
        
        HashMap<String, Integer> noteMap = new HashMap();
        for (String s : note) {
            if (noteMap.containsKey(s)) {
                Integer newValue = noteMap.get(s) + 1;
                noteMap.put(s, newValue);
            }
            else {
                noteMap.put(s, 1);
            }
        }
       
        String output = "Yes";
        for (String s : noteMap.keySet()) {
            if (magazineMap.getOrDefault(s, 0) < noteMap.get(s)) {
                output = "No";
                break;
            }
        }
        
        System.out.println(output);
    }

