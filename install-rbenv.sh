brew install rbenv ruby-build

# bash
echo 'export PATH="$HOME/.rbenv/bin:$PATH"' >> ~/.bash_profile
echo 'eval "$(rbenv init -)"' >> ~/.bash_profile  

# zsh
echo 'export PATH="$HOME/.rbenv/bin:$PATH"' >> ~/.zprofile
echo 'eval "$(rbenv init -)"' >> ~/.zprofile  

# list all available versions:
rbenv install -l

# install a Ruby version:
rbenv install 2.4.1

# set ruby version for a specific dir
rbenv local 2.4.1

rbenv rehash
gem update --system
