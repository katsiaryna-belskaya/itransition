 def gethashes(path)
	data = File.binread(path)
	data_hash = OpenSSL::Digest.new('SHA3-256')
	digest = data_hash.digest(data)
   return digest
end

dir = Dir.pwd
files = Dir.entries(dir).select { |f| File.file? File.join(dir, f) }

files.each(|file| puts file + " " + gethashes(File.join(dir, file)))

