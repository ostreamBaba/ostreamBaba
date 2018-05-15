### browser = webdriver.Firefox()报错的问题

* 报错问题: “selenium.common.exceptions.WebDriverException: Message: 'geckodriver' executable needs to be in PATH.”

* 这里是说需要geckodriver这个东西添加到你的环境变量Path里面

* linux系统 sudo mv geckodriver /usr/local/bin

* pip list查selenium版本(3.12.0) firefox --v 火狐版本(Mozilla Firefox 55.0)
    * 有人安装还是不行，那可能与selenium版本和firefox版本有关

- [geckodriver](https://github.com/mozilla/geckodriver/releases)
