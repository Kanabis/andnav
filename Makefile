
SVN_BRANCH=./branches/android-1.5-pinned-entity-refactor/AndNav2
GIT_REPOS=../../git_andnav

help:
	echo "This makefile is for synchronizing git with svn"

push: ${GIT_REPOS}
	echo "pushing changes from git to svn"
	rsync --archive --verbose --update --progress \
		--filter 'exclude .git' \
		--filter 'exclude bin/' \
		--filter 'exclude gen/' \
		--filter 'exclude R.java' \
		${GIT_REPOS}/ ${SVN_BRANCH}

pull: ${GIT_REPOS}
	echo "syncing changes between git to svn"
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

