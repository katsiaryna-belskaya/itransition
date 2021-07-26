const crypto = require('crypto');
const fs = require('fs');

const dir = process.cwd();
var path = require('path');

function gethashes(filename) {
	var content = fs.readFileSync(filename, 'utf8');
	const hash = crypto.createHash('sha3-256');
	return hash.update(content).digest("hex")
}

fs.readdir(dir, (err, files) => {
    if (err) {
        throw err;
    }
     files.forEach(file => {
     	if (!file.startsWith(".")&& !fs.statSync(path.join(dir,file)).isDirectory()) {
        	console.log(`${file} ${gethashes(path.join(dir,file))}`);
        }
    });
});


    	
