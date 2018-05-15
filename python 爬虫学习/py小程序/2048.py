from selenium import webdriver
from selenium.webdriver.common.keys import Keys

browser = webdriver.Firefox()

url = 'https://gabrielecirulli.github.io/2048/'
browser.get(url)
game_ele = browser.find_element_by_class_name('game-container')
while True:
    retry_ele = browser.find_element_by_class_name('retry-button')
    if retry_ele.text == 'Try again':
        retry_ele.click()
        game_ele = browser.find_element_by_class_name('game-container')
    game_ele.send_keys(Keys.RIGHT)
    game_ele.send_keys(Keys.UP)
    game_ele.send_keys(Keys.DOWN)
    game_ele.send_keys(Keys.LEFT)
