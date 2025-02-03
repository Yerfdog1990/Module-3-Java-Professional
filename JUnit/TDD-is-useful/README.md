### Tdd is useful
Here’s a detailed example of a function that appears simple but has several corner cases that make it challenging to implement correctly. This example can effectively demonstrate the value of unit testing and Test-Driven Development (TDD).

### Example Function: `compressString`

**Problem Statement:**
Write a function `compressString(String input)` that compresses a string using the counts of repeated characters. For example:
- Input: `"aabcccccaaa"`
- Output: `"a2b1c5a3"`

If the "compressed" string would not become smaller than the original string, the function should return the original string.

### Why This Problem Is Tricky:
At first glance, the problem seems straightforward: count consecutive characters and concatenate the character with its count. However, there are several corner cases that make the implementation more challenging:

1. **Edge Cases**:
    - Empty string (`""`)
    - Single character string (`"a"`)
    - Strings with no consecutive repeating characters (`"abcdef"`)

2. **Compression Length**:
    - The compressed string might be longer than the original, in which case you should return the original string (`"abcd"` should return `"abcd"` rather than `"a1b1c1d1"`).

3. **Different Character Types**:
    - Handling strings with numbers or special characters (`"aa$$bb"` should return `"a2$2b2"`).

4. **Large Input**:
    - Handling performance concerns with very large strings.

This repo tells the story of how to solve this problem:
1. First, without using TDD, just visually verifying the output in the standard output.
2. Second, after showing the inconveniences of doing it that way, start over using TDD.

The idea is to prove to new developers or sceptics that TDD can be a useful approach to solve complex (or simple) algorithmic problems.
Each commit message, along with changes in code, tell that story.