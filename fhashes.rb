require 'sha3'
 def gethashes(path)
	data = File.binread(path)
   return SHA3::Digest::SHA256.hexdigest(data)
end

dir = Dir.pwd
files = Dir.entries(dir).select { |f| File.file? File.join(dir, f) }

files.each{|file| puts file + " " + gethashes(File.join(dir, file))}
