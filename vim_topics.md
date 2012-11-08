# Vim

## Vim Modes

  * Normal mode
  * Insert mode
  * Visual mode
  * Command Line mode (Ex mode)

## Navigation

### Move word by word

        w  Forward to start of next word
        b  Backward to start of current/previous word
        e  Forward to end of current/next word
        ge Backward to end of previous word

Understand the difference between word and WORD

### Find by character

        f{char}  Forward to the next occurrence of {char}
        F{char}  Backward to the previous occurrence of {char}
        t{char}  Forward to the character before the next occurrence of {char}
        T{char}  Backward to the character after the previous occurrence of {char}
        ;        Repeat the last character-search command
        ,        Reverse the last character-search command

### Search to Navigate

  * Use search to quickly navigate.
  * Combine it that any command that takes a motion like 
        d{motion}
        c{motion} etc

### Jumping between matching paranthesis

    val xs = List[ "one", "two", "three" ]

### Others

  * Use line numbers
  * `H` `M` `L` to navigate to the Home, Middle or Bottom of the window repectively

## Dot Command (find ways to use it)

Dot command lets you repeat your last change

## Use text objects for precise selection & editing

    a)  a pair of (parentheses)
    i)  inside of (parentheses)
    a}  a pair of (braces)
    i}  inside of (braces)
    at  a pair of tags
    it  inside of tags

Works similarly for square brackes, angle brackets, single quotes, double quotes and backquotes

    iw  current word
    aw  current word plus one space
    is  current sentence
    as  current sentence plus one space
    ip  current paragraph
    ap  current paragraph plus one blank line

## Expression Register

  * Basic Arithmetic using expression register `<C-r>=`
  * Numbered list example using expression register

## Fun with Visual Mode

  * `gv` reselect the last visual mode selection
  * Edit tabular data with visual block mode [**file:** _depth_chart.txt_)
  * Change columns of text

## Whitespace sanity

    set list
    set listchars=tab:>-,trail:·

## Command-line Mode

  * Run normal mode commands

        `:'<,'> normal .` execute dot command over visual selection
        `:% normal A;` add semicolon at the end of each line
        `:% normal i//` add comment to all lines

  * `<C-r><C-w>` inserts current word at the command prompt

        `:%s//<C-r><C-w>/g`

  * Run commands in the shell
  * Filter buffer contents through an external command (Ex: "sort -t',' -k2") [**file:** _people.csv_]
  * Duplicate/Move lines :t and :m

        :6t.     Copy line 6 to just below the current line
        :t6      Copy the current line to just below line 6
        :t.      Duplicate the current line (similar to Normal mode yyp) 
        :t$      Copy the current line to the end of the file
        :'<,'>t0 Copy the visually selected lines to the start of the file

## Pattern Matching

  * Case sensitivity of searches (`incsearch`, `hlsearch`, `smartcase`)
  * 'very magic' switch  (\v)    [**file:** _people.csv_]
  * 'very nomagic' switches (\V) [Ex: 'i.e.' vs 'iced']
  * Reuse last search pattern

        %s//.../

  * Use parentheses to capture submatches

        \v^([^,]*,\s*)([^,]*,\s*)(.*)$
        :%s//\2\1\3

  * Word boundries

        /\<macro\>  (or)
        /\v<macro>

## Searching

  * nohlsearch usage  (`<leader>/` mapping)

## Substitution

## Global

  * Deleting lines containing a pattern

        :g//d

  * Keeping lines matching a pattern

        :v/href/d

  * Collect items to a register [File: _GroovyP..P..C...java_]

        :g/TODO/yank A       (:let @a="" to clear a register)
        :put a
        :g/TODO/t$           (if you want to copy it to the end of the same file instead)

## Macros

  * Recording and executing macros
  * Repeat macro on contiguous lines

        3@a
        normal @a

  * Execute macros in serial and parallel  (show macro that would break searially)
  * Editing macros

        :put a
        edit macro in buffer
        "add

## Persistent Undos

## Plugins

  * Tabularize
  * Ctrl-P
  * Gundo - Graphical undo plugin
  * Zoomwin
  * Fugitive
  * Surround
  * Tslime

## Misc

  * Paste contents of register in insert and command mode  (Ctrl-R <reg>)

        <Ctrl-R>0 to paste hidden register
        <Ctrl-R>/ to paste the last search

