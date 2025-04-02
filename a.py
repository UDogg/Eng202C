import socket
import subprocess
import time
from random import choice
from scapy.all import IP, TCP, UDP, Raw, send

# Target honeypot
TARGET_IP = "192.168.110.213"
ATTACK_PORT = 4444

# Simulated C2/malware-style payloads
ATTACK_PAYLOADS = [
    b"GET /cgi-bin/backdoor.sh HTTP/1.1\r\nHost: malware\r\n\r\n",
    b"POST /login HTTP/1.1\r\nHost: evil\r\nContent-Length: 35\r\n\r\nusername=admin&password=hackme",
    b"cmd=upload&token=rat1337",
    b"rm -rf / --force",
    b"<script>document.location='http://evil';</script>",
    b"heartbeat=alive&bot_id=xyz123",
    b"download http://192.168.110.213/malware.exe",
]

def connect_tcp(ip, port):
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.settimeout(1)
        s.connect((ip, port))
        s.close()
        print(f"[+] TCP connection to {ip}:{port} succeeded")
    except:
        print(f"[-] TCP connection to {ip}:{port} failed (expected)")

def connect_udp(ip, port):
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.sendto(b"udp_test_payload", (ip, port))
        s.close()
        print(f"[+] UDP datagram sent to {ip}:{port}")
    except:
        print(f"[-] UDP send to {ip}:{port} failed")

def scapy_tcp_syn(ip, port):
    pkt = IP(dst=ip)/TCP(dport=port, flags="S")
    send(pkt, count=1, verbose=0)
    print(f"[+] Scapy TCP SYN sent to {ip}:{port}")

def scapy_udp(ip, port):
    pkt = IP(dst=ip)/UDP(dport=port)/Raw(load="scapy_payload")
    send(pkt, count=1, verbose=0)
    print(f"[+] Scapy UDP packet sent to {ip}:{port}")

def curl_http(ip, port, payload):
    try:
        subprocess.run(
            ["curl", "-X", "POST", f"http://{ip}:{port}/", "--data", payload.decode(errors="ignore")],
            timeout=3,
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL
        )
        print(f"[+] curl POST to {ip}:{port} with payload")
    except Exception as e:
        print(f"[-] curl to {ip}:{port} failed: {e}")

def telnet_attempt(ip, port):
    try:
        subprocess.run(
            ["telnet", ip, str(port)],
            input=b"ping_botnet\n",
            timeout=2,
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL
        )
        print(f"[+] telnet connection attempt to {ip}:{port}")
    except Exception as e:
        print(f"[-] telnet to {ip}:{port} failed (expected): {e}")

def send_attack_payload(ip, port, payload):
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.settimeout(2)
        s.connect((ip, port))
        s.send(payload)
        print(f"[+] Sent C2-style payload to {ip}:{port}: {payload[:30]}...")
        s.close()
    except Exception as e:
        print(f"[-] Failed to send attack payload to {ip}:{port}: {e}")

def simulate_beaconing(ip, port, interval=5, count=5):
    print(f"[+] Simulating C2 beaconing to {ip}:{port}")
    for i in range(count):
        payload = b"heartbeat=alive&bot_id=bot" + str(i).encode()
        send_attack_payload(ip, port, payload)
        time.sleep(interval)

def main():
    print("[*] Launching all attack types to port 4444 only\n")
    for _ in range(5):
        payload = choice(ATTACK_PAYLOADS)
        connect_tcp(TARGET_IP, ATTACK_PORT)
        connect_udp(TARGET_IP, ATTACK_PORT)
        scapy_tcp_syn(TARGET_IP, ATTACK_PORT)
        scapy_udp(TARGET_IP, ATTACK_PORT)
        curl_http(TARGET_IP, ATTACK_PORT, payload)
        telnet_attempt(TARGET_IP, ATTACK_PORT)
        send_attack_payload(TARGET_IP, ATTACK_PORT, payload)
        time.sleep(1)

    simulate_beaconing(TARGET_IP, ATTACK_PORT)

    print("\n[+] All attacks sent to port 4444. On the honeypot, run:")
    print("    sudo lsof -i TCP:4444 -n -P | grep ESTABLISHED")
    print("    sudo tcpdump -nnX port 4444")

if __name__ == "__main__":
    main()
