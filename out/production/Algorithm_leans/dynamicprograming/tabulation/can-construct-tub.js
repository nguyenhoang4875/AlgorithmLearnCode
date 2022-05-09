const canConstructTub = (target, wordBank) => {
    const table = Array(target.length + 1).fill(false);
    table[0] = true;

    for (let i = 0; i <= target.length; i++) {
        if (table[i] == true) {
            for (let word of wordBank) {
                if (target.slice(i, i + word.length) === word) {
                    table[i + word.length] = true;
                }
            }
        }
    }

    return table[target.length];

}

console.log(canConstructTub("abcdef", ["ab", "abc", "cd", "def", "abcd"]))// true
console.log(canConstructTub("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]))//false
console.log(canConstructTub("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"]))// true
console.log(canConstructTub("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
    ["e",
        "ee",
        "eee",
        "eeee",
        "eeeee",
        "eeeeee",
        "eeeeeee"]))//false

// Time: O(m^2*n)
// Space: O(m)
