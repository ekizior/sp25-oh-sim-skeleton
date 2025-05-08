# CS 61B Fall 2025 OH Simulation

Hi! Welcome to the CS 61B OH simulation! During this stage, we want to see how you help students in a 1-1 office hours style situation.

## What to Expect

During the 10-15 minute simulation, one of the interviewers will be acting as a student in office hours who requires assistance on a hash maps assignment. The student will have a partial implementation, so your goal is identify where the student is struggling and assist them! The goal is not to find the most bugs, but to help the student learn as much as they can.

There are no required materials for you to prepare other than thinking about the questions in the email. But, if you would like to get an idea of what the interview might look like, the skeleton code for the assignment is provided in this repository and an assignment spec is given below.

During the interview, you will be working on this simulation with your interviewer's computer, but here are instructions if you would like to try the assignment locally on your own computer! Let us know if you have any questions by replying to the email (cs61b@berkeley.edu).

## Tips

During this interview, we're looking to see how you interact with and assist students! A couple of tips to keep in mind:

- The goal is to best help the student with what they're struggling on. Keep in mind what their major misconceptions seem to be!
- Equip students with skills that they can keep for the future. For example, taking a student's computer and fixing their errors won't help them learn!
- Treat the student how you would like to be treated when you ask for help!

## Setting Up the Assignment

1. Check that you have Git and Java installed on your computer. If not, follow the instructions in this section [here](https://fa24.datastructur.es/labs/lab01/#personal-computer-setup)!
2. We will be using the IntelliJ IDE during this exercise. You can install IntelliJ through [these instructions](https://fa24.datastructur.es/labs/lab01/#task-intellij-setup).
3. Clone the `library-fa24` repository with the instructions listed [here](https://fa24.datastructur.es/labs/lab01/#java-libraries).
4. Clone [this repository](https://github.com/ekizior/sp25-oh-sim-skeleton).
5. Open the project in IntelliJ and follow the [Assignment Workflow steps](https://fa24.datastructur.es/resources/guides/assignment-workflow/#opening-in-intellij) to prepare your setup.
6. At this point, you should be ready to work on the assignment! To quickly check, you should see green buttons in the test files under the `tests` directory. Clicking on these buttons should allow you to run the tests!

## Spec

In this assignment, you’ll work on `MyHashMap`, a hash table-based implementation of the `Map61B` interface.

### File Structure

`src/hashmap/Map61B.java`: In this file, you'll find an interface for the basic map operations: `get`, `put`, `containsKey`, and `size`.

`src/hashmap/MyHashMap.java`: A `MyHashMap` implements the `Map61B` interface and supports the four operations using a hash table.

`tests/hashmap/TestMyHashMap`: This file contains tests. You do not need to modify this file, but understanding how some of the tests work could be useful!

### MyHashMap

_The instructions are a summarized version of this semester's [Lab 8 assignment](https://fa24.datastructur.es/labs/lab08/). See there for more details!_

The implementation of `MyHashMap` utilizes a hash table with external chaining, similar to what's described [in lecture](https://docs.google.com/presentation/d/1lT5wE53Dv38x_XfJ09Fj-rq975qeUumekbu_0ogvxgA/edit#slide=id.g1f6a0dff07b_0_1102).

In the skeleton, we've provided a `Node` class where each node contains a key-value pair. The buckets in a `MyHashMap` are kept in a variable `buckets` of type `List<Node>[]` (array of Lists).

`void put(K key, V value)`: Assigns `value` to the specified `key` within the hash map. If the `key` already existed in the map, the old value should be updated to the specified value. `put` should cause the `MyHashMap` to multiplicatively resize when the load factor is exceeded.

`V get(K key)`: Retrieves the associated value for the specified `key`. If no `key` is found in the map, returns null.

`boolean containsKey(K key)`: Returns true if the `key` is contained in the map, otherwise returns false.

`int size()`: Returns the number of key-value mappings stored in this map.
