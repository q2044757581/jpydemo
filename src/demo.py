class PersonConsumerCallback:
    def __init__(self):
        self.hello_str = "hello world!"
        print("started")

    def say_words(self, words):
        print(words)
        return True

    def set_words(self, words):
        self.hello_str = words

    def say_hello(self):
        print(self.hello_str)
