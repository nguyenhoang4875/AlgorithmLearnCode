const countConstructTub = (target, wordBank) => {
    const table = Array(target.length + 1).fill(0);
    table[0] = 1;

    for (let i = 0; i <= target.length; i++) {
        for (let word of wordBank) {
            if (target.slice(i, i + word.length) === word) {
                table[i + word.length] += table[i];
            }
        }
    }

    return table[target.length];
}

// m = target.length, n = wordBank.length
// Time: O(n*m)
// Space: (m)


console.log(countConstructTub("purple", ["purp", "p", "ur", "le", "purpl"])); // 2
console.log(countConstructTub("abcdef", ["ab", "abc", "cd", "def", "adbc"])); // 1
console.log(countConstructTub("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // 0
console.log(countConstructTub("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); // 4
console.log(countConstructTub("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee",
    "eeeeeeeeeeee"])); // 0
