    ///////////////////////////////////////////////////////////////////////////
    // NOTE: this file isn't intended to compile; it's simply a place for me //
    // to dump my solutions to the problems for my own future reference      //
    ///////////////////////////////////////////////////////////////////////////

    // Super Reduced String
    // https://www.hackerrank.com/challenges/reduced-string/problem
    static StringBuilder stripString(StringBuilder builder) {
        for (int i = 0; i < builder.length() - 1; i++) {
            char char1 = builder.charAt(i);
            char char2 = builder.charAt(i + 1);

            if (char1 == char2) {
                builder.deleteCharAt(i);
                builder.deleteCharAt(i);
            }
        }
        
        return builder;
    }
    static String superReducedString(String s) {
        if (s.length() < 2) {
            return s;
        }
        else {
            StringBuilder builder = new StringBuilder(s);            
          
            boolean hadPairs = false;
            do {
                int originalLength = builder.length();
                builder = stripString(builder);
                int strippedLength = builder.length();
                if (strippedLength < originalLength) {
                    hadPairs = true;
                }
                else {
                    hadPairs = false;
                }
            } while (hadPairs && builder.length() > 1);
             
            String finalResult = builder.toString();
            if (finalResult.length() < 1) {
                return "Empty String";
            }
            else {
                return finalResult;
            }
        }
    }

    // Insert a node at a specific position in a linked list
    // https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data,
                                                     int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        
        if (head == null) {
            return newNode;
        }
        else {
            if (position == 0) {
                newNode.next = head;
                return newNode;
            }
            else {
                int currentPosition = 1; // already accounted for pos. 0
                SinglyLinkedListNode currentNode = head;
                
                while (currentPosition < position) {
                    currentPosition++;
                    currentNode = currentNode.next;
                }
                
                SinglyLinkedListNode nextNode = currentNode.next;
                currentNode.next = newNode;
                newNode.next = nextNode;
                
                return head;
            }
        }
    }

    // Insert a node at the head of a linked list
    // https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        // note the var name llist doesn't make sense given it's a single node but it's theirs
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        
        if (llist == null) {
            return newNode;
        }
        else {
            newNode.next = llist; // set new node's pointer to previous head node
            return newNode;
        }
    }

    // Insert a Node at the Tail of a Linked List
    // https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
       
        // head node doesn't exist / empty list
        if (head == null) {
            return newNode;
        }
        // there's at least a one-node list, so add on to it
        else {
            SinglyLinkedListNode cursor = head; // probably should make a copy constructor
            
            while (cursor.next != null) {
                cursor = cursor.next;
            }
            
            cursor.next = newNode;
            return head;
        }
    }

    // Flipping bits
    // https://www.hackerrank.com/challenges/flipping-bits/problem
    // 
    // Whew! This was a challenging one, but I did it!
    static long flippingBits(long n) {
        List<Long> bits = new ArrayList<>();
        
        // get remainders to fill bit slots
        long numerator = n;
        if (numerator == 0L) {
            bits.add(0L); // special case of incoming decimal of 0
        }
        else {
            while (numerator > 0L) {
                long remainder = numerator % 2L;
                numerator = numerator / 2L;
                bits.add(remainder);
            }
        }
        
        // have to reverse the bits because otherwise e.g. 4 would be 001 instead of 100
        Collections.reverse(bits);
        
        // pad front of binary columns with zeros
        if (bits.size() < 32) {
            int lengthDifference = 32 - bits.size();
            for (int i = 0; i < lengthDifference; i++) {
                bits.add(0, 0L);
            }
        }
        
        // flip bits
        for (int i = 0; i < bits.size(); i++) {
            bits.set(i, bits.get(i) == 1L ? 0L : 1L);
        }
       
       
        // have to reverse again because we're going up from 1 to 2 to 4...
        Collections.reverse(bits);
        
        // construct new base 10 integer
        long total = 0L;
        long binaryColumn = 1L;
        for (long bit : bits) {
            total += (bit * binaryColumn);
            binaryColumn *= 2L;
        }
        
        return total;
    }

    // Tree: Height of a Binary Tree
    // https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
    //
    // I had to look this one up. But I did walk through several cases of using it
    // on a whiteboard until I understood how it worked.
    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
       
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);
        
        return left > right ? left : right;
    }

    // Minimum Absolute Difference in an Array
    // https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
    static int absoluteDifference(int[] arr, int a, int b) {
        return Math.abs(arr[a] - arr[b]);
    }
    
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr); // the two integers producing min diff will be next to each other
        
        int smallestDiff = absoluteDifference(arr, 0, 1);
        
        for (int i = 0; i < arr.length - 1; i++) {
            int newDiff = absoluteDifference(arr, i, i + 1);
            
            if (newDiff < smallestDiff) {
                smallestDiff = newDiff;
            }
        }
        
        return smallestDiff;
    }

    // Luck Balance
    // https://www.hackerrank.com/challenges/luck-balance/problem
    static int luckBalance(int k, int[][] contests) {
        int totalLuck = 0;
        int nonImportantContests = 0;
        
        // sum up the luck for NON-important contests (second dimension of array == 0)
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 0) { // check to see if non-important contest
                nonImportantContests++;
                totalLuck += contests[i][0]; // potential luck of that particular contest
            }
        }
       
        // save processing if no contests were marked important
        if (nonImportantContests == contests.length) {
            return totalLuck;
        }
       
        List<Integer> importantContests = new ArrayList<>();
        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 1) { // check to see if important contest
                importantContests.add(contests[i][0]);
            }
        }
       
        // sort by biggest luck first
        Collections.sort(importantContests, Collections.reverseOrder());
       
        int numOfImportantContests = importantContests.size();
        
        // it's possible to have more allowed to lose than available to lose
        // this prevents array out of bounds
        int maxContestsAvailableToLose = k;
        if (numOfImportantContests < k) {
            maxContestsAvailableToLose = numOfImportantContests;
        }
        
        for (int i = 0; i < maxContestsAvailableToLose; i++) {
            // contests we can lose, thereby gaining luck up to total of k contests
            totalLuck += importantContests.get(i);
        }
        
        // only do if we have more important contests than num we're allowed to lose
        for (int i = k; i < numOfImportantContests; i++) {
            // contests we have to win, therefore losing luck
            totalLuck -= importantContests.get(i);
        }

        return totalLuck;
    }
  
    // Strings: Making Anagrams
    // https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
    static int getCountsDifference(String a, String b, char c) {
        int countA = StringUtils.countMatches(a, c);
        int countB = StringUtils.countMatches(b, c);
        return Math.abs(countA - countB);
    }
    
    static int makeAnagram(String a, String b) {
        int totalDeletions = 0;
        List<Character> charsSeen = new ArrayList<>();
        
        char[] aChars = new char[a.length()];
        char[] bChars = new char[b.length()];
        a.getChars(0, a.length(), aChars, 0);
        b.getChars(0, b.length(), bChars, 0);
        
        for (char c : aChars) {
            if (!charsSeen.contains(c)) {
                charsSeen.add(c);
                totalDeletions += getCountsDifference(a, b, c);
            }
        }
        
        for (char c : bChars) {
            if (!charsSeen.contains(c)) {
                charsSeen.add(c);
                totalDeletions += getCountsDifference(a, b, c);
            }
        }
        
        return totalDeletions;
    }

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
