# Zsh

## History substring search

You can use `UP arrow` for history substring search

## Extremely intelligent TAB completion

## Full vi line editing

  * Navigation (like `cw`)
  * `fc` (edit previous command in full vi)
  * Search history with anchors

## Spelling correction

## Unix command option expansion

        ls -<TAB>

## Right side prompt

## Secondary Prompt

## Globbing (wildcards on steroids)

        vi **/README.md    #... Recursively finds README.md and opens it for editing (works in BASH too)
        vi **/*.md <<TAB>>

        ls -l *(<<TAB>>
        ls -l *(:<<TAB>>

        ls -l *(Lk+50)     #... List file size larger/greater than 50 KB
        ls -l *(.om[1,3])  #... List newest 3 files

## Modifiers

        * :h --> head (dirname)
        * :t --> tail (basename)
        * :r --> rest (extension removed)
        * :e --> extension only
        * :l --> convert to lowercase
        * :u --> convert to uppercase

        $ for f (*.sh) mv $f $f:r
        $ for f (*.txt) mv $f $f:l

## Process substitution

        $ vi =(cmd)            # ... (edits the output of cmd - writes cmd output to a temp file)
        $ vi <(cmd)            # ... (edits the output of cmd - writes cmd output to a named pipe)

## Automatic file stream teeing (Multi-IO)

        $ ls > out1 > out2      # ... Stores the output of ls in 2 files
        $ ls > file1 > file2 >> file3 | wc -l
        $ ls -l > file1 | grep 'file*'

## Directory Stacks

        alias dh='dirs -v'
        echo $DIRSTACKSIZE
        cd -2
        cd -<<TAB>>

        cd ....

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

        sleep 100 &
        sleep 50 &
        kill s<<TAB>>

## Git Integration

## Push to Stack and Resume

        bindkey '\C-Q' push-line-or-edit
        bindkey -M viins '^O' copy-prev-shell-word

## Vared

Inline variable editing with full command line vi bindings

        vared PATH

## Edit command line in Vi

        autoload       edit-command-line
        zle -N         edit-command-line
        bindkey '\C-E' edit-command-line

## For Expression

        for i ({1..5}) touch $i.txt
        touch {1..5}.txt

## History Substitution

### Current line

        !#:0    command
        !#^     first parameter
        !#:1    first parameter
        !#:1-4  first 4 parameters
        !#$     last parameter
        !#*     all parameters
        !#$:s/bash/zsh perform substitution on previous parameter

        cp somedir/somefile.txt !#$:s/.txt/.bak/
        cp somedir/somefile.txt !#$:r

        cp somedir/somefile.txt !#$:<<TAB>>     (show how you can look at the available modifiers)

        mv Some\ File\ with\ spaces.pdf !#^:gs/\\ //<TAB>
        <ESC>u    (undo the change)
        Include a `_` and <TAB> again

### Copying / Renaming files

        cp verylongfilename.txt backup_!#^
        cp {,backup_}verylongfilename.txt     # same thing
        mv textfile.{txt,bak}                 # expands to mv textfile.txt textfile.bak

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

## zmv
        autoload -U zmv
        alias mmv='noglob zmv -W'

        mmv *.txt *.bak
        zmv -W '*.txt' '*.bak'

## fasd

The name fasd comes from the default suggested aliases `f`(files),`a`(files/directories),`s`(show/search/select),`d`(directories).

        f  regular files
        d  directories
        v  open frecent file in vi
        z  cd into frecent directory

## Magic space

        % echo hello
        hello

        % !1 world
        echo hello world
        hello world

        % bindkey " " magic-space
        % !1

