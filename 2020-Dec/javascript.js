

// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/js10-bitwise/problem

function getMaxLessThanK(n, k) {
    let max = 0;
    let series = []
    
    for (var i = 1; i <= n; i++) {
        series.push(i)
    }
    
    for (var a = 1; a <= n-1; a++) {
        for (var b = a+1; b <= n; b++) {
            if (parseInt(a&b) >= k) {
                return max
            }
            else {
                if (parseInt(a&b) > max) {
                    max = parseInt(a&b)
                }
            }
        }
    }
    
    return max
}
// ---------------------------------------------------------------------------

