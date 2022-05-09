const allConstruct = (target, wordBank, memo = {}) => {
    if (target in memo) return memo[target];
    if (target === '') return [[]];

    const result = [];

    for (let word of wordBank) {
        if (target.indexOf(word) == 0) {
            const suffix = target.slice(word.length);
            const suffixWays = allConstruct(suffix, wordBank, memo);
            const targetWays = suffixWays.map(way => [word, ...way]);
            result.push(...targetWays);
        }
    }

    memo[target] = result;
    return result;
}

// m = target.length
// n = wordBank.length
//
// Brute Force
// Time: O(n^m)
// Time: O(m)
//
// Memorized
// Time: O(n*m)
// Space: O(m)


console.log(allConstruct("purple", ["purp", "p", "ur", "le", "purpl"]));
// [
//   [ "purp", "le" ]
//   [ "p", "ur", "p", "le" ]
// ]

console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "adbc", "ef", "c"]));
// [
//   [ "ab", "cd", "ed" ]
//   [ "ab", "c", "def" ]
//   [ "abc", "def" ]
//   [ "abcd", "ef" ]
// ]

console.log(allConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]));
// []
console.log(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaz", ["a", "aa", "aaa", "aaaa", "aaaaa"]));
// []
