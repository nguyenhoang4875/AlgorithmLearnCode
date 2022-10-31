# Modulo in competitive programming
## Addition:
```shell
(a + b) % MOD = (a % MOD + b % MOD) % MOD
```

## Subtraction:
```shell
ans = (a - b) % MOD
ans = (a % MOD - b % MOD) % MOD
if (ans < 0) ans += MOD 

OR
(a - b) % MOD = ((a % MOD  - b % MOD) + MOD ) % MOD
<=> (a - b ) = (a % MOD - b % MOD + MOD) % MOD
```

## Multiplication
```shell
(a * b) % MOD = ((a % MOD) * (b % MOD)) % MOD
```

## Division
```shell
(a / b) % MOD = (a * b^-1) % MOD = ((a % MOD) * (b^-1 % MOD)) % MOD

Calculate: b^-1 % MOD
ans = b^-1 % MOD
when b is prime number
b^-1 % MOD = (b^(MOD-2)) % MOD
```
### Calculation the binary exponentiation (a ^ b)
```java
     long biPow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
            ans *= a;
            }
            a *= a;
            b /= 2;
        }
        return ans;
     }
```

