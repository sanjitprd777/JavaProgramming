package coding;

import java.util.*;

/*
🔹 Problem Statement:
Given a stream of words, predict the most frequent next word.
Must run in O(1) prediction time.

🔹 Example Input:
["I am great", "Great is me", "I am fool", "I like Running", "I like Football", "I like Singing"]

🔹 Expected Output:
If a user types "I", return "like", because "I like" appears 3 times.

🔹 Follow-ups:

How to update the frequency efficiently when new data arrives?
What if we need to predict the next 2 most frequent words?

 */

class Node implements Comparable<Node> {
    String word;
    int frequency;

    Node(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(other.frequency, this.frequency);
    }
}

class Solution {
    // Map to store word pairs and their frequencies
    private Map<String, Map<String, Node>> wordPairs;
    private Map<String, PriorityQueue<Node>> wordpq;
    
    public Solution() {
        wordPairs = new HashMap<>();
        wordpq = new HashMap<>();
    }
    
    // Process a new sentence from the stream
    public void processSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            // Get or create the inner map for the current word
            Map<String, Node> nextWords = wordPairs.getOrDefault(currentWord, new HashMap<>());
            PriorityQueue<Node> pq = wordpq.getOrDefault(currentWord, new PriorityQueue<>());

            // Update frequency of the word pair
            Node node = nextWords.get(nextWord);
            Node newNode = new Node(nextWord, 1);
            if (node != null) {
                pq.remove(node);
                newNode = new Node(nextWord, node.frequency + 1);
            }
            nextWords.put(nextWord, newNode);
            pq.add(newNode);
            wordPairs.put(currentWord, nextWords);
            wordpq.put(currentWord, pq);
        }
    }
    
    // Predict the most frequent next word (O(1) time)
    public String predictNextWord(String currentWord) {
        PriorityQueue<Node> pq = wordpq.get(currentWord);
        if (pq == null || pq.isEmpty()) {
            return null;
        }
        
        // Find the word with maximum frequency
        return pq.peek().word;
    }
    
    // Get top k most frequent next words (O(k log n) time)
    public List<String> predictTopKNextWords(String currentWord, int k) {
        PriorityQueue<Node> pq = wordpq.get(currentWord);
        if (pq == null || pq.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Extract top k words without deleting them from the priority queue
        List<String> result = new ArrayList<>();
        List<Node> temp = new ArrayList<>();    
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            temp.add(pq.poll());
        }
        for (Node node : temp) {
            pq.add(node);
        }
        for (Node node : temp) {
            result.add(node.word);
        }
        
        return result;
    }
}

public class TopKWords {
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // Test the implementation
        String[] sentences = {
            "I am great",
            "Great is me",
            "I am fool",
            "I like Running",
            "I like Football",
            "I like Singing"
        };
        
        // Process all sentences
        for (String sentence : sentences) {
            s.processSentence(sentence);
        }
        
        // Test predictions
        System.out.println("Most frequent next word after 'I': " + s.predictNextWord("I"));
        System.out.println("Top 2 most frequent next words after 'I': " + s.predictTopKNextWords("I", 2));
        System.out.println("Top 3 most frequent next words after 'I': " + s.predictTopKNextWords("I", 3));
        System.out.println("Top 3 most frequent next words after 'like': " + s.predictTopKNextWords("like", 3));
    }
}
