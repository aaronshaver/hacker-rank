    ///////////////////////////////////////////////////////////////////////////
    // NOTE: this file isn't intended to compile; it's simply a place for me //
    // to dump my solutions to the problems for my own future reference      //
    ///////////////////////////////////////////////////////////////////////////

    // Alternating Characters
    // https://www.hackerrank.com/challenges/alternating-characters/problem
    static int alternatingCharacters(String s) {
        int deletionsRequired = 0;
        char currentCharacter;
        
        currentCharacter = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char nextCharacter = s.charAt(i);
            if (nextCharacter == currentCharacter) {
                // repeated A or B, so increase deletion count
                deletionsRequired++;
            }
            else {
                // switch from A to B, or from B to A, so switch what we're looking for
                currentCharacter = nextCharacter;
            }
        }
    
        return deletionsRequired;
    }

    // Sorting: Bubble Sort
    // https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] =  temp;
    }
    
    static void countSwaps(int[] a) {
        // note: could be optimized with the "keep track of last unsorted element" trick
        final int n = a.length;
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaps++;             
                }
            }
        }     
        System.out.println(String.format("Array is sorted in %d swaps.", swaps));
        System.out.println(String.format("First Element: %d", a[0]));
        System.out.println(String.format("Last Element: %d", a[a.length - 1]));
    }

    // Two Strings
    // https://www.hackerrank.com/challenges/two-strings/problem
    static String twoStrings(String s1, String s2) {
        
        // high level note: probably should have use a set data structure for this
        
        // store a map of each unique char found in first string for later lookup
        HashMap<Character, Boolean> indexedCharacters = new HashMap<>();
        for (char c : s1.toCharArray()) {
            indexedCharacters.putIfAbsent(c, true);
        }
        
        // check to see if current char exists in our hashmap created earlier
        for (char c : s2.toCharArray()) {
            if (indexedCharacters.containsKey(c)) {
                return "YES";   
            } 
        } 
        return "NO";
    }

    // Mark and Toys
    // https://www.hackerrank.com/challenges/mark-and-toys/problem
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        
        int toysCount = 0;
        for (int price : prices) {
            if (price <= k) {
                k -= price;
                toysCount++;
            }
        } 
        
        return toysCount;
    }

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

    // Arrays: Left Rotation
    // https://www.hackerrank.com/challenges/ctci-array-left-rotation/
    static int[] rotLeft(int[] a, int d) {
        if (a.length == d) {
            return a;  // no need to do computations if rotations equals array size
        }
        int[] secondPart = Arrays.copyOfRange(a, 0, d);
        int[] firstPart = Arrays.copyOfRange(a, d, a.length);
        int[] finalResult = ArrayUtils.addAll(firstPart, secondPart);
        return finalResult;
    }

