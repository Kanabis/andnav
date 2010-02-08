
SVN_BRANCH=./branches/android-1.5-pinned-entity-refactor/AndNav2
GIT_REPOS=../../git_andnav

help:
	echo "This makefile is for synchronizing git with svn"

svn2git: ${GIT_REPOS}
	echo "pulling updates from svn to git"
	rsync --archive --verbose --update --progress \
		--filter 'merge ./.rsync-filter' \
		${SVN_BRANCH}/ ${GIT_REPOS}/

git2svn: ${GIT_REPOS}
	echo "pushing changes from git to svn"
	rsync --archive --verbose --update --progress \
		--filter 'merge  ./.rsync-filter' \
		${GIT_REPOS}/ ${SVN_BRANCH}

sync: ${GIT_REPOS}
	echo "syncing changes between git to svn"
	rsync --archive --verbose --update --progress \
		--filter 'merge ./.rsync-filter' \
		${SVN_BRANCH}/ ${GIT_REPOS}/

${GIT_REPOS}:
	mkdir ${GIT_REPOS}
	cd ${GIT_REPOS}; git init  

