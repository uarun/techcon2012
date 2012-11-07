class HelloSpock extends Specification {
    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length
        name.startsWith(startsWith)

        where:
        name | length | startsWith
        "Spock" | 5 | "S"
        "Kirk" | 4 | "K"
        "Scotty" | 6 | "S"
    }
}
