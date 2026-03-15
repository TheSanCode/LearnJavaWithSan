# EnergyPacketDistribution

## Problem Summary

Given an array of energy packets and a number of agents, the goal is to find the **maximum energy each agent can receive equally**.

Each packet can be split into smaller equal parts, but every agent must receive the same amount of energy.

## Example

If the packets are:

```java
[10, 20, 30]
```

and the number of agents is:

```java
5
```

then the answer is:

```java
10
```

Reason:

- From `10`, we can create `1` part of size `10`
- From `20`, we can create `2` parts of size `10`
- From `30`, we can create `3` parts of size `10`

Total parts = `6`, which is enough for `5` agents.

If we try a larger value like `11`, the number of equal parts becomes too small, so `10` is the maximum possible answer.

## Approach Used

The solution uses **binary search on the answer**.

Instead of trying every possible energy value one by one, the code searches efficiently between:

- `1` as the minimum possible energy per agent
- `max(packets)` as the maximum possible energy per agent

For every middle value `mid`, the program checks whether it is possible to serve at least the required number of agents.

## How the Logic Works

### 1. Handle invalid input

If:

- the packet array is `null`
- the packet array is empty
- the number of agents is `0` or negative

the method returns `0`.

### 2. Find the search range

The largest packet value is used as the upper bound because no agent can receive more energy than the biggest available packet size.

### 3. Apply binary search

The algorithm keeps checking a candidate value `mid`:

- If `mid` works, store it as the current answer and try a bigger value.
- If `mid` does not work, try a smaller value.

This continues until the best possible value is found.

### 4. Check feasibility

The helper method:

```java
canDistribute(long[] packets, long agents, long target)
```

counts how many agents can receive `target` energy.

For each packet:

```java
count += packet / target;
```

This means:

- if `packet = 20` and `target = 5`, then `20 / 5 = 4`
- so that packet can serve `4` agents

If the total count becomes greater than or equal to `agents`, then distribution is possible.

## Why Binary Search Works Here

This problem has a monotonic property:

- If a target value is possible, then every smaller target value is also possible.
- If a target value is not possible, then every larger target value is also not possible.

Because of this property, binary search is the correct and efficient choice.

## Time Complexity

Let:

- `n` be the number of packets
- `m` be the maximum packet value

Then:

- Each feasibility check takes `O(n)`
- Binary search runs in `O(log m)`

Overall time complexity:

```text
O(n log m)
```

Space complexity:

```text
O(1)
```

## Code Walkthrough

In [com/dds/learn/java/EnergyPacketDistribution.java](com/dds/learn/java/EnergyPacketDistribution.java), the main method is:

```java
public long solution(long[] packets, long agents)
```

Its steps are:

1. Validate the input.
2. Find the maximum packet value.
3. Use binary search to test possible energy values.
4. Use `canDistribute()` to check whether a value is feasible.
5. Return the maximum valid value.

## Sample Dry Run

For:

```java
packets = [10, 20, 30]
agents = 5
```

Search space:

- `left = 1`
- `right = 30`

Possible checks:

- `mid = 15` -> only `0 + 1 + 2 = 3` agents can be served, so not enough
- `mid = 7` -> `1 + 2 + 4 = 7`, enough
- `mid = 11` -> `0 + 1 + 2 = 3`, not enough
- `mid = 10` -> `1 + 2 + 3 = 6`, enough

Final answer:

```java
10
```

## Conclusion

This solution is efficient and scalable because it avoids checking every possible value directly. Using binary search makes it suitable even when packet values are very large.