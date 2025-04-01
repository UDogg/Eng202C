import socket
import threading
import time

host = '0.0.0.0'
port = 4444

def handle_client(conn, addr):
    print(f"[+] Connection from {addr}")
    try:
        data = conn.recv(1024)
        if data:
            print(f"[>] Payload: {data[:80]!r}")
        time.sleep(20)
    except Exception as e:
        print(f"[!] Error from {addr}: {e}")
    finally:
        conn.close()
        print(f"[-] Closed connection from {addr}")

s = socket.socket()
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.bind((host, port))
s.listen(29)

print(f"[*] Listening on port {port}...")

try:
    while True:
        conn, addr = s.accept()
        t = threading.Thread(target=handle_client, args=(conn, addr))
        t.daemon = True
        t.start()
except KeyboardInterrupt:
    print("\n[*] Exiting.")
    s.close()
