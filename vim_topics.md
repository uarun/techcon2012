# Vim

## Vim Modes

  * Normal mode
  * Insert mode
  * Visual mode
  * Command Line mode

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
  * Combine it that any command that takes a motion like d{motion}, c{motion} etc

### Jumping between matching paranthesis

    val xs = List[ "one", "two", "three" ]

### Others

  * Use line numbers
  * H M L to navigate to the Home, Middle or Bottom of the window repectively

## Dot Command (find ways to use it)

Dot command lets you repeat your last change

    var x = 1
    var y = 2
    var z = x + y

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
  * Edit tabular data with visual block mode
  * Change columns of text

## Whitespace sanity

## Command-line Mode

  * Run normal mode commands
    - `:'<,'> normal .` execute dot command over visual selection
    - `:% normal A;` add semicolon at the end of each line
    - `:% normal i//` add comment to all lines
  * `<C-r><C-w>` inserts current word at the command prompt
    - `:%s//<C-r><C-w>/g`
  * Run commands in the shell
  * Filter buffer contents through an external command (Ex: "sort -t',' -k2")

## Pattern Matching

  * Case sensitivity of searches
  * 'very magic' and 'very nomagic' switches
  * Use parentheses to capture submatches
  * Word boundries

## Searching

  * nohlsearch usage

## Substitution

## Macros

  * Recording and executing macros
  * Repeat macro on contiguous lines
  * Execute macros in serial and parallel
  * Editing macros

## Plugins

  * Gundo - Graphical undo plugin
  * Zoomwin
  * Fugitive
  * Tabularize
  * Ctrl-P
  * Surround
  * Tslime

