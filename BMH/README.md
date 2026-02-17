# Secret Code Finder – Boyer Moore Horspool

This project solves a pattern-search problem where a specific string must be located inside a large text file, with 
more than 50,000 characters.

For every occurrence of the target pattern, the algorithm records the starting index (0-based) and concatenates all
indices in order of appearance to generate a secret code.

## Example:

If the pattern appears at positions:

`5, 0, 0, 3`

The resulting secret code is:

`5003`


## Why Boyer Moore Horspool Instead of KMP?

Although Knuth Morris Pratt (KMP) guarantees linear time complexity O(n + m), Boyer Moore Horspool offers significant
practical advantages for this specific problem.

### 1. Practical Performance

- BMH frequently runs in sublinear time
- It performs large jumps when mismatches occur
- It reduces total character comparisons

In real-world text (mixed letters and digits), BMH often outperforms KMP.

### 2. Real-World Efficiency

For large text files:

- KMP processes characters sequentially without large jumps.
- BMH skips sections of the text whenever possible.

In practical benchmarks, BMH tends to be faster for single-pattern searches in natural text.

## Time Complexity

| Algorithm | Worst Case | Average Case |
| --------- | ---------- |--------------|
| KMP       | O(n + m)   | O(n + m)     |
| BMH       | O(n · m)   | O(n / m)     |

Although BMH has a worse theoretical worst-case bound, for large text files and a single search pattern, Boyer Moore Horspool
provides:

- Faster practical execution
- Fewer character comparisons
- Efficient memory usage


>[!Note]
> You can generate random data using this [reference](https://codebeautify.org/generate-random-string)