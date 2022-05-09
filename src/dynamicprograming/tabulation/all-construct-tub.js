const allConstructTub = (target, wordBank) => {
    const table = Array(target.length + 1).fill().map(() => []);

    table[0] = [[]];

    for (let i = 0; i <= target.length; i++) {
        for (let word of wordBank) {
            if (target.slice(i, i + word.length) === word) {
                const newCombinations = table[i].map(subArray => [...subArray, word]);
                table[i + word.length].push(...newCombinations);
            }

        }

    }
    return table[target.length];
}

// m = target.length
// n = wordBank.length
//
// Memorized
// Time: O(m^n)
// Space: O(m^n)


console.log(allConstructTub("purple", ["purp", "p", "ur", "le", "purpl"]));
// [
//   [ "purp", "le" ]
//   [ "p", "ur", "p", "le" ]
// ]

console.log(allConstructTub("abcdef", ["ab", "abc", "cd", "def", "adbc", "ef", "c"]));
// [
//   [ "ab", "cd", "ed" ]
//   [ "ab", "c", "def" ]
//   [ "abc", "def" ]
//   [ "abcd", "ef" ]
// ]

console.log(allConstructTub("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]));
// []
console.log(allConstructTub("aaaaaaaaaaaaaaaz", ["a", "aa", "aaa", "aaaa", "aaaaa"]));
// []

