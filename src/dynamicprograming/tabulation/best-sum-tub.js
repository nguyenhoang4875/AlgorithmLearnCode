const bestSumTub = (targetSum, numbers) => {
    const table = Array(targetSum + 1).fill(null);
    table[0] = [];

    for (let i = 0; i < targetSum; i++) {
        if (table[i] !== null) {
            for (let num of numbers) {
                const combination = [...table[i], num];
                // if this current combination is shorter that what is already stored
                if (!table[i + num] || table[i + num].length > combination.length) {
                    table[i + num] = combination;
                }
            }
        }

    }

    return table[targetSum];
}


console.log(bestSumTub(7, [5, 3, 4, 7])); //[7]
console.log(bestSumTub(8, [2, 3, 5])); // [3, 5]
console.log(bestSumTub(8, [1, 4, 5])); // [4, 4]
console.log(bestSumTub(100, [1, 2, 5, 25])); // [25, 25, 25, 25]

// Time: O(m^n)
// Space: O(m^2)

