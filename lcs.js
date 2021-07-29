// if(process.argv.length>2){
// let a=process.argv.slice(2);
// var arr= a.concat().sort(),
// a1= arr[0], a2= arr[arr.length-1], L= a1.length, i= 0;
// while(i< L && a1.charAt(i)=== a2.charAt(i)) i++;
// console.log (a1.substring(0, i));
// }


// function longest_common_starting_substring(arr1){
// var arr= arr1.concat().sort(),
// a1= arr[0], a2= arr[arr.length-1], L= a1.length, i= 0;
// console.log(arr);
// console.log(a1);
// console.log(a2);
// while(i< L && a1.charAt(i)=== a2.charAt(i)) i++;
// return a1.substring(0, i);
// }

// console.log(longest_common_starting_substring(process.argv.slice(2))); 


function m(s) {
    var r = [], i, j, l = s.length;
    for (i = 0; i < l; i++) {
        for (j = l; j - i >= 0; j--) {
            r.push(s.slice(i, j));
        }
        return r
    }
}


var arr1 = "ZZZABXXX", arr2 = "XXXYYYAB";
var arr = ["ABCDEFGH", "ABCDEFG", "AxBCDEF", "ABCDxE", "EDCBCAABCD"], a = [];

// console.log(m1(arr[0]));
// console.log(m1(arr[2]));

// for(var k=1;k<arr.size;k++) 
// 	//a=m(arr[0]).filter(v => m(arr[k]).includes(v));
//  a.concat(m(arr[0]).filter(x => m(arr[k]).includes(x)));
// console.log(a);
function match(s1, s2) {
    var r = [];
    for (let i in s1)
        s2.includes(i) ? count++ : false;

    console.log(count)
}

console.log(match(arr[0]), arr[1])
console.log(arr[0].split("").filter(x => arr[1].split("").includes(x)))
//console.log(m(arr[0]).filter(x => m(arr[2]).includes(x)))
//var a=m(arr1).filter(v => m(arr2).includes(v));
//console.log(a.sort(function (a, b) { return b.length - a.length })[0])



