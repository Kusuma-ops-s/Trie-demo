
# Trie (Prefix Tree) Implementation & Algorithms in Java

A comprehensive implementation of a **Trie (Prefix Tree)** data structure in Java, written to demonstrate custom node-linking algorithms, string search logic, prefix matching, unique substring counting, and longest common prefix discovery.

## 🚀 Features & Algorithms

* **Core Trie Operations:**
  * Bulk insertion of words into the tree.
  * Fast string search (`search`).
  * Prefix search validation (`startsWith`).

* **Advanced String Algorithms:**
  * **Longest Word / Prefix Search (`longestPrefix`):** Recursively traverses nodes with `endOfWord` markers to find the longest compound word constructed character by character.
  * **Unique Substring Counter (`noOfsub`):** Generates all suffixes of a string and inserts them into the Trie to calculate the total count of unique substrings using total node creation steps.
  * **Partial Word Matching (`searchparts`):** Searches for valid trailing substring matches within a given string query.

---

## 🛠️ Method & Complexity Summary

| Method | Description | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| `insert(String[] words, Node root)` | Inserts an array of words into the Trie. | **O(N × L)** | **O(N × L)** |
| `search(String word, Node root)` | Checks if a full word exists in the Trie. | **O(L)** | **O(1)** |
| `startsWith(String str, Node root)` | Checks if any word starts with the given prefix. | **O(L)** | **O(1)** |
| `noOfsub(String st)` | Counts total distinct substrings of a string using Trie nodes. | **O(L²)** | **O(L²)** |
| `longestPrefix(Node cur, StringBuilder temp)` | Finds the longest constructed string using backtracking DFS. | **O(26 × L)** | **O(L)** call stack |

*Where **N** is the number of words, and **L** is the maximum word/string length.*
