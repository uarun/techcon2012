# Command Line Fu

## Full vi line editing

## Spelling correction

## Process substitution

    $ vi =(cmd)            # ... (edits the output of cmd - writes cmd output to a temp file)
    $ vi <(cmd)            # ... (edits the output of cmd - writes cmd output to a named pipe)

## Generalized Pipes

## Modifiers

    * :h --> head (dirname)
    * :t --> tail (basename)
    * :r --> rest (extension removed)
    * :e --> extension only
    * :l --> convert to lowercase
    * :u --> convert to uppercase

    $ for f (*.sh) mv $f $f:r
    $ for f (*.txt) mv $f $f:l

## Automatic file stream teeing (Multi-IO)

    $ ls > out1 > out2      # ... Stores the output of ls in 2 files
    $ ls > file1 > file2 >> file3 | wc -l
    $ ls -l > file1 | grep 'file*'

## Globbing

    $ vi **/README.md    #... Recursively finds README.md and opens it for editing (works in BASH too)
    $ vi **/*.md <<TAB>>

## Directory Stacks

    $ alias dh='dirs -v'
    $ echo $DIRSTACKSIZE
    $ cd -2
    $ cd -<<TAB>>

## Right side prompt

## Directory substitution

    cd ~/projects/sample/src/main/java/com/liquidnet/example/
    cd java scala

## Aliases

### Suffix Alias

    alias -s java=vim

With that entering Main.java at the command prompt and hitting enter will invoke vim Main.java

### Global Alias

Global aliases can be used anywhere on the command line

    alias -g PG='| less'
    alias -g C='| wc -l'

## Completing Process IDs

## Git Integration

## Push to Stack and Resume

    bindkey '\C-Q' push-line-or-edit
    bindkey -M viins '^O' copy-prev-shell-word

## Vared

    vared PATH

## Edit command line in Vi

    autoload       edit-command-line
    zle -N         edit-command-line
    bindkey '\C-E' edit-command-line

## History Substitution

### Current line

    !#:0    command
    !#^     first parameter
    !#:1    first parameter
    !#:1-4  first 4 parameters
    !#$     last parameter
    !#*     all parameters
    !#$:s/bash/zsh perform substitution on previous parameter

    $ cp somedir/somefile.txt !#$:s/.txt/.bak/
    $ cp somedir/somefile.txt !#$:r
    $ cp somedir/somefile.txt !#$:<<TAB>>

### Copying / Renaming files

    cp longfilename.txt backup_!#^
    cp {,backup_}verylongfilename.txt   # same thing
    mv textfile.{txt,bak}               # expands to mv textfile.txt textfile.bak

### Previous Commands

    !-1     repeat whole command
    !!      repeat (shortcut)
    !:0     command
    !^      first parameter
    !:1     first parameter
    !:1-4   first 4 parameters
    !$      last parameter
    !*      all parameters
    !!:s/bash/zsh (or ^bash^zsh)
    !^:t    just file name of first parameter
    !$:h    just path of last parameter
    !-2$:r  just file name without extension of first parameter

## Magic space

    % echo hello
    hello

    % !1 world
    echo hello world
    hello world

    % bindkey " " magic-space
    % !1
