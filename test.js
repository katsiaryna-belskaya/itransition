//function m(a){let s=a.reduce((a, b)=>a.length<=b.length?a:b);let m=s.length;for(let l=m;l>=0;l--){for(let b=0;b<=m-l;b++){let r=s.substring(b,b+l);if(a.every(x=>~x.indexOf(r))){return r;}}}return '';}if(process.argv.length<3)console.log('');else console.log(lcs(process.argv.slice(2)));




f=a=>(g=b=s=>a.every(x=>~x.indexOf(s))?b=b[s.length]?b:s:g(s.slice(0,-1,g(s.slice(1)))))(a[0]);
f1=a=>(F=(l,n,w=a[0].substr(n,l))=>l?n<0?F(--l,L-l):a.some(y=>y.indexOf(w)<0)?F(l,n-1):w:"")(L=a[0].length,0)
console.log(f1(process.argv.slice(2)));
