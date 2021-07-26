from os import listdir, getcwd
from os.path import join, abspath, isfile
import hashlib

def get_hash(path):
	with open(path, encoding='utf-8') as file:
		line = file.read()
	return hashlib.sha3_256(str.encode(line)).hexdigest()

def main():
	path = abspath(getcwd())
	for file in listdir(path):
		if not file.startswith(".") and isfile(file):
			print(file + " " + get_hash(join(path, file)))

if __name__=="__main__":
	main()

