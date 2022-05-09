const howSum = (targetSum, numbers, memo = {}) => {
    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    for (let num of numbers) {
        const remainder = targetSum - num;
        const remainderResult = howSum(remainder, numbers, memo);
        if (remainderResult !== null) {
            memo[targetSum] = [...remainderResult, num];
            return [...remainderResult, num];
        }

    }

    memo[targetSum] = null
    return null;
}

// m = target sum
// n = numbers.length
//
// Brute Force
// Time: O(n^m*m)
// Space: O(m)
//
// Memorized
// Time: O(n*m^2)
// Space: O(m^2)

console.log(howSum(7, [2, 3])); //[3, 2, 2]
console.log(howSum(7, [5, 3, 4, 7])); // [4, 3]
console.log(howSum(7, [2, 4]));// null
console.log(howSum(8, [2, 3, 5])); // [2, 2, 2, 2]
console.log(howSum(300, [7, 14])); // null
