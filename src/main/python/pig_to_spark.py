
def remove_comments(string):
    length = len(string)

    i = 0

    result = ""

    while i < length:
        ch = string[i]

        if ch == "'":
            result += ch
            i += 1

            while i < length and string[i] != "'":
                result += string[i]
                i += 1

            if i < length and string[i] == "'":
                result += string[i]

            i += 1
        elif ch == "-":
            if i + 1 < length and string[i + 1] == "-":
                i += 2

                while i < length and string[i] != "\n":
                    i += 1
            else:
                result += ch
                i += 1
        elif ch == "/":
            if i + 1 < length and string[i + 1] == "*":
                i += 2

                while i < length:
                    if i + 1 < length and not (string[i] == "*" and string[i + 1] == "/"):
                        i += 1
                    else:
                        i += 2

                        break
            else:
                result += ch
                i += 1
        else:
            result += ch
            i += 1

    return result


def main():
    string = """
    
        /**
        wqerqwer
        qewrqwer
        ****/
        
        a = 1; --aaaaa
        b = 1;
        --adfwqerqwrqwerqwerqewr
        c = 3;
    """

    f = open("/Users/lixiao/Desktop/mdm_hm_edw_app_data_usage.pig")

    string = ""

    for line in f:
        string += (line)

    result = remove_comments(string)

    print(result)


main()
