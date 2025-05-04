# pip install pynput Pillow

from pynput.keyboard import Key, Listener
from PIL import ImageGrab
import time

def on_press(key):
    try:
        if key == Key.f9:
            print("F9 presionada, tomando screenshot...")
            screenshot = ImageGrab.grab()
            screenshot.save(f"screenshot_{int(time.time())}.png")
            print("Screenshot guardado!")
    except Exception as e:
        print(f"Error: {e}")

def on_release(key):
    if key == Key.esc:
        return False

with Listener(on_press=on_press, on_release=on_release) as listener:
    listener.join()
