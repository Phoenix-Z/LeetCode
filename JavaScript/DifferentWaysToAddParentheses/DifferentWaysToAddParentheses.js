/**
 * (119ms)
 * @param {string} input
 * @return {number[]}
 */
var diffWaysToCompute = function(input) {
   var ans = [];
   for(var i = 0; i < input.length; i++) {
       if(input[i] === '+' || input[i] === '-' || input[i] === '*') {
           var left = diffWaysToCompute(input.slice(0, i));
           var right = diffWaysToCompute(input.slice(i + 1));
           for(let l of left) {
               for(let r of right) {
                   var res;
                   switch(input[i]) {
                       case '+':
                           res = l + r;
                           break;
                       case '-':
                           res = l - r;
                           break;
                       case '*':
                           res = l * r;
                           break;
                   }
                   ans.push(res);
               }
           }
       }
   }
   if(ans.length === 0) {
       ans.push(Number(input));
   }
   return ans;
};