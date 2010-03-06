
SVN_BRANCH=./branches/android-1.5-pinned-entity-refactor/AndNav2
# SVN_BRANCH=../../git-back
GIT_REPOS=../../git_andnav

help:
	echo "This makefile is for synchronizing git with svn"

fromgit: tosvn

tosvn: ${GIT_REPOS}
	echo "syncing differences from git to svn"
	rsync --archive --verbose --update --progress \
		--filter 'exclude .git' \
		--filter 'exclude bin/' \
		--filter 'exclude gen/' \
		--filter 'exclude R.java' \
		${GIT_REPOS}/ ${SVN_BRANCH}

fromsvn: togit

togit: ${GIT_REPOS}
	echo "syncing differences from svn to git"
	rsync --archive --verbose --update --progress \
		--filter 'exclude .git' \
		--filter 'exclude .svn' \
		--filter 'exclude bin/' \
		--filter 'exclude gen/' \
		--filter 'exclude R.java' \
		${SVN_BRANCH}/ ${GIT_REPOS}/

${GIT_REPOS}:
	mkdir ${GIT_REPOS}
	cd ${GIT_REPOS}; git init  

