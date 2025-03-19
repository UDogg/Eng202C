# **Botnets for Research: A Guide to Ethical Deployment, Detection, and Mitigation**

Disclaimer: This guide is intended for research and educational purposes only. Unauthorized use of botnets is illegal. All implementations should be performed in a controlled, isolated environment (e.g., air-gapped VM or sandboxed Docker network). This document alone is nowhere near enough to attack any individual let alone an organization. Students do not have enough resources to orchestrate an attack

[**1. Introduction	4**](#1.-introduction)

[**2. History of Botnets	5**](#2.-history-of-botnets)

[Early Developments and Origins	5](#early-developments-and-origins)

[Transition to Sophisticated Networks	6](#transition-to-sophisticated-networks)

[The Mirai Botnet and the Rise of IoT Vulnerabilities	6](#the-mirai-botnet-and-the-rise-of-iot-vulnerabilities)

[The Growth of Botnet Capabilities	6](#the-growth-of-botnet-capabilities)

[Security Concerns and the Impact on Cyber Defense	7](#security-concerns-and-the-impact-on-cyber-defense)

[Conclusion	7](#conclusion)

[**3. Common Misunderstandings	7**](#3.-common-misunderstandings)

[Distinguishing Between Botnets, Worms, and Viruses	8](#distinguishing-between-botnets,-worms,-and-viruses)

[Misinterpretation of Botnet Activity: DDoS vs. Botnet Functionality	8](#misinterpretation-of-botnet-activity:-ddos-vs.-botnet-functionality)

[The Honeypot Analogy: GIF of a Venus Flytrap	9](#the-honeypot-analogy:-gif-of-a-venus-flytrap)

[Debunking Myths and Misconceptions	9](#debunking-myths-and-misconceptions)

[Emphasizing Clarity in Cybersecurity Terminology	10](#emphasizing-clarity-in-cybersecurity-terminology)

[**4. Table of Positive and Negative Uses of Botnets	10**](#4.-table-of-positive-and-negative-uses-of-botnets)

[**Good and bad uses of Botnets	11**](#good-and-bad-uses-of-botnets)

[**5. Mini Implementation of a Malicious Toy Botnet	11**](#5.-mini-implementation-of-a-malicious-toy-botnet)

[5.1 Overview and Objectives	11](#5.1-overview-and-objectives)

[5.2 Environment Setup	12](#5.2-environment-setup)

[5.3 Design of the Self-Replicating Worm	12](#5.3-design-of-the-self-replicating-worm)

[5.4 Implementation Details	12](#5.4-implementation-details)

[5.4.1 Initialization and Configuration	12](#5.4.1-initialization-and-configuration)

[5.4.2 The Replication Engine	13](#5.4.2-the-replication-engine)

[5.4.3 Hiding the Worm	14](#5.4.3-hiding-the-worm)

[5.4.4 Payload Execution	14](#5.4.4-payload-execution)

[5.4.5 Main Function	15](#5.4.5-main-function)

[5.5 Analysis and Monitoring	15](#5.5-analysis-and-monitoring)

[5.6 Ethical Considerations and Best Practices	15](#5.6-ethical-considerations-and-best-practices)

[5.7 Conclusion	16](#5.7-conclusion)

[**6. Deploying the Botnet in Ubuntu 22.04 VM	16**](#6.-deploying-the-botnet-in-ubuntu-22.04-vm)

[6.1 Virtual Machine Setup	16](#6.1-virtual-machine-setup)

[6.2 Installing Essential Dependencies	17](#6.2-installing-essential-dependencies)

[6.3 Configuring the Environment	18](#6.3-configuring-the-environment)

[6.4 Step-by-Step Botnet Deployment	19](#6.4-step-by-step-botnet-deployment)

[Step 1: Launching the Botnet Controller	19](#step-1:-launching-the-botnet-controller)

[Step 2: Deploying Botnet Nodes via Docker	20](#step-2:-deploying-botnet-nodes-via-docker)

[Step 3: Coordinating Replication and Payload Delivery	22](#step-3:-coordinating-replication-and-payload-delivery)

[6.5 Verification and Monitoring	22](#6.5-verification-and-monitoring)

[6.6 Best Practices and Final Considerations	23](#6.6-best-practices-and-final-considerations)

[6.7 Conclusion	23](#6.7-conclusion)

[**7. Detecting the Botnet & IDS Animation	23**](#7.-detecting-the-botnet-&-ids-animation)

[7.1 Understanding Botnet Detection	24](#7.1-understanding-botnet-detection)

[7.2 Designing the Intrusion Detection System (IDS)	24](#7.2-designing-the-intrusion-detection-system-(ids))

[7.2.1 Implementing the IDS: A Step-by-Step Approach	25](#7.2.1-implementing-the-ids:-a-step-by-step-approach)

[7.3 Practical Example: IDS Detection Code	25](#7.3-practical-example:-ids-detection-code)

[7.4 Visualizing Detection with GIF Animation	27](#7.4-visualizing-detection-with-gsap-animation)

[7.4.1 Conceptualizing the Animation	27](#7.4.1-conceptualizing-the-animation)

[7.5 Integration and Impact of the IDS Animation	29](#7.5-integration-and-impact-of-the-ids-animation)

[7.6 Summary and Conclusion	29](#7.6-summary-and-conclusion)

[**8. Implementing a Mesh-Based Honeypot (100 Docker Nodes)	30**](#8.-implementing-a-mesh-based-honeypot-(100-docker-nodes))

[8.1 Introduction and Objectives	30](#8.1-introduction-and-objectives)

[8.2 Architectural Overview	30](#8.2-architectural-overview)

[8.3 Environment Setup and Pre-deployment Considerations	31](#8.3-environment-setup-and-pre-deployment-considerations)

[8.3.1 Hardware and Virtualization Requirements	31](#8.3.1-hardware-and-virtualization-requirements)

[8.3.2 Software Dependencies	31](#8.3.2-software-dependencies)

[8.4 Detailed Implementation Steps	32](#8.4-detailed-implementation-steps)

[8.4.1 Containerizing the Honeypot Nodes	32](#8.4.1-containerizing-the-honeypot-nodes)

[8.4.2 Deploying 100 Docker Containers	33](#8.4.2-deploying-100-docker-containers)

[8.4.3 Inter-Node Communication with Redis	34](#8.4.3-inter-node-communication-with-redis)

[8.4.4 Setting Up the Command and Control (C2) Server	35](#8.4.4-setting-up-the-command-and-control-(c2)-server)

[8.4.5 Logging and Visualization Using the ELK Stack	36](#8.4.5-logging-and-visualization-using-the-elk-stack)

[8.5 Mesh Topology and Network Considerations	38](#8.5-mesh-topology-and-network-considerations)

[8.6 Security and Ethical Considerations	38](#8.6-security-and-ethical-considerations)

[8.7 Data Analysis and Post-Incident Review	39](#8.7-data-analysis-and-post-incident-review)

[8.8 Challenges and Lessons Learned	39](#8.8-challenges-and-lessons-learned)

[8.9 Future Enhancements and Research Directions	40](#8.9-future-enhancements-and-research-directions)

[8.10 Conclusion	41](#8.10-conclusion)

[**8.5 Using a Layered Architecture to Detect a Botnet	41**](#8.5-using-a-layered-architecture-to-detect-a-botnet)

[Introduction	41](#introduction)

[The Rationale Behind a Layered Detection Architecture	42](#the-rationale-behind-a-layered-detection-architecture)

[Key Components of the Layered Architecture	42](#key-components-of-the-layered-architecture)

[1. Intrusion Prevention Systems (IPS)	42](#1.-intrusion-prevention-systems-(ips))

[2. Firewalls	43](#2.-firewalls)

[3. Security Information and Event Management (SIEM) Tools	43](#3.-security-information-and-event-management-(siem)-tools)

[4. Automated Blacklisting of Botnet C2 Servers	43](#4.-automated-blacklisting-of-botnet-c2-servers)

[5. Signature-Based vs. Anomaly-Based Detection	43](#5.-signature-based-vs.-anomaly-based-detection)

[Integrating Detection Layers: A Practical Workflow	44](#integrating-detection-layers:-a-practical-workflow)

[Case Study: Coordinated Botnet Detection	45](#case-study:-coordinated-botnet-detection)

[Scenario Overview:	45](#scenario-overview:)

[Layered Response:	45](#layered-response:)

[Best Practices for Deploying a Layered Architecture	45](#best-practices-for-deploying-a-layered-architecture)

[Future Directions and Innovations	46](#future-directions-and-innovations)

[Conclusion	47](#conclusion-1)

[**9. Capturing and Reverse Engineering the Worm	47**](#9.-capturing-and-reverse-engineering-the-worm)

[9.1 Introduction	48](#9.1-introduction)

[9.2 Capturing the Worm from Honeypot Logs	48](#9.2-capturing-the-worm-from-honeypot-logs)

[9.2.1 Log Collection Strategy	48](#9.2.1-log-collection-strategy)

[9.2.2 Extracting Relevant Log Data	48](#9.2.2-extracting-relevant-log-data)

[9.3 Installing Redis for Event Sharing	49](#9.3-installing-redis-for-event-sharing)

[9.3.1 Redis Deployment and Configuration	49](#9.3.1-redis-deployment-and-configuration)

[9.3.2 Publishing and Subscribing to Event Channels	50](#9.3.2-publishing-and-subscribing-to-event-channels)

[9.4 Configuring Cowrie to Forward Honeypot Data to ELK	50](#9.4-configuring-cowrie-to-forward-honeypot-data-to-elk)

[9.4.1 Modifying Cowrie Configuration	50](#9.4.1-modifying-cowrie-configuration)

[9.4.2 Testing the Forwarding Mechanism	51](#9.4.2-testing-the-forwarding-mechanism)

[9.5 Reverse Engineering the Worm Using Ghidra	51](#9.5-reverse-engineering-the-worm-using-ghidra)

[9.5.1 Overview of Ghidra	51](#9.5.1-overview-of-ghidra)

[9.5.2 Preparing the Worm Binary for Analysis	51](#9.5.2-preparing-the-worm-binary-for-analysis)

[9.5.3 Importing and Analyzing in Ghidra	52](#9.5.3-importing-and-analyzing-in-ghidra)

[9.5.4 Example Analysis Walkthrough	53](#9.5.4-example-analysis-walkthrough)

[9.6 Post-Analysis and Remediation Strategies	53](#9.6-post-analysis-and-remediation-strategies)

[9.7 Conclusion	54](#9.7-conclusion)

[**10. Positive Use Case: Load Testing a Kubernetes Network	54**](#10.-positive-use-case:-load-testing-a-kubernetes-network)

[10.1 Introduction	55](#10.1-introduction)

[10.2 Background: Distributed Traffic Generation and Load Testing	55](#10.2-background:-distributed-traffic-generation-and-load-testing)

[10.3 Kubernetes Cluster Architecture for Load Testing	55](#10.3-kubernetes-cluster-architecture-for-load-testing)

[10.4 Implementing Botnet-Like Distributed Traffic Generation	56](#10.4-implementing-botnet-like-distributed-traffic-generation)

[Key Components of the Load Generation Framework:	56](#key-components-of-the-load-generation-framework:)

[10.5 Step-by-Step Deployment Process	56](#10.5-step-by-step-deployment-process)

[10.5.1 Setting Up the Kubernetes Cluster	56](#10.5.1-setting-up-the-kubernetes-cluster)

[10.5.2 Deploying the Load Generation Agents	57](#10.5.2-deploying-the-load-generation-agents)

[10.5.3 Coordinating Load via a Central Controller	58](#10.5.3-coordinating-load-via-a-central-controller)

[10.6 Performance Analysis and Metrics	59](#10.6-performance-analysis-and-metrics)

[10.7 Challenges and Lessons Learned	59](#10.7-challenges-and-lessons-learned)

[10.8 Conclusion	60](#10.8-conclusion)

[**11. Conclusion	61**](#11.-conclusion)

[Recap of Key Themes	61](#recap-of-key-themes)

[The Importance of a Layered Approach	61](#the-importance-of-a-layered-approach)

[Practical Implementation and Future Directions	62](#practical-implementation-and-future-directions)

[Final Reflections	62](#final-reflections)

[**Appendix A: Glossary of Terms	62**](#appendix-a:-glossary-of-terms)

[**Appendix B: References and Citations	63**](#appendix-b:-references-and-citations)

## **1. Introduction** {#1.-introduction}

In the rapidly evolving digital landscape, botnets have emerged as one of the most significant and multifaceted challenges—and opportunities—in the field of cybersecurity. This document is intended for research and educational purposes only, and every experiment described herein should be carried out exclusively within controlled, isolated environments such as air-gapped virtual machines or sandboxed Docker networks. Unauthorized deployment or experimentation with botnets is illegal and unethical.

A **botnet** is a network of internet-connected devices—ranging from personal computers and smartphones to a multitude of IoT devices—that have been compromised by malware. Once infected, these devices become “bots” under the control of a remote operator, often referred to as the botmaster. The botmaster can command these bots to perform a variety of tasks simultaneously, such as launching Distributed Denial of Service (DDoS) attacks, distributing spam emails, or even stealing sensitive data, all while remaining largely invisible to the device owners.

Complementing the concept of a botnet is the **worm**. Unlike viruses, which typically require human intervention to spread, worms are self-contained programs designed to exploit vulnerabilities automatically and propagate through networks without user action. **Self-replicating worms** take this capability even further by continuously duplicating themselves across network nodes, often using multiple pathways to maximize their rate of spread. This relentless self-replication can overwhelm system resources, making detection and mitigation an even greater challenge.

Key terms that will recur throughout this guide include:

* **Botnet:** A collective of compromised devices orchestrated to perform coordinated actions.  
* **Worm:** A standalone malware entity that propagates without user aid.  
* **Self-Replicating Worm:** An advanced form of worm engineered to rapidly multiply across systems.  
* **Command and Control (C2):** The infrastructure through which a botmaster communicates with and directs the bots.  
* **Honeypot:** A deliberately vulnerable system set up to attract and analyze cyber attackers.

The primary purpose of this guide is to demystify the technology behind botnets by delving into their historical evolution, underlying mechanisms, and both malicious and ethical applications. Through rigorous, step-by-step analysis and experimentation, researchers and cybersecurity professionals can learn to deploy controlled botnet environments. This, in turn, enhances our collective understanding of how such networks are constructed and how they operate, ultimately contributing to more robust defensive measures.

In the chapters that follow, we will explore the origins and evolution of botnets, clarify common misconceptions surrounding them, and present detailed methods for ethical deployment and detection. Our goal is to create a comprehensive resource that not only examines the technical aspects of botnets but also reinforces the importance of adhering to legal and ethical standards in cybersecurity research.

By systematically unpacking these complex subjects, this document aims to serve as both a technical reference and a practical guide, fostering innovation and encouraging responsible research practices in the realm of network security.

## **2. History of Botnets** {#2.-history-of-botnets}

The evolution of botnets mirrors the rapid development of network technologies and the increasing complexity of cybersecurity challenges. This section delves into the historical milestones, key developments, and pivotal incidents that have shaped the landscape of botnet technology over the years.

### **Early Developments and Origins** {#early-developments-and-origins}

In the nascent stages of computer networking, researchers and hackers alike began experimenting with networked devices. The concept of remote control over machines was initially explored in academic environments and through early experiments in network security. Early botnets emerged as rudimentary networks created using simple scripts, which allowed a single controller to manipulate multiple machines simultaneously. These early networks were often benign in intent, built primarily to test the limits of distributed computing and remote administration.

The primary focus during these formative years was on understanding how automated systems could manage routine tasks across several devices. Experimentation with early networked environments revealed that even modest systems could be repurposed to perform tasks remotely if vulnerabilities were identified and exploited. This realization laid the groundwork for what would eventually evolve into more structured and potent botnets.

### **Transition to Sophisticated Networks** {#transition-to-sophisticated-networks}

As computer networks expanded and internet connectivity became more widespread, so did the ambitions of cyber adversaries. The evolution from simple scripts to more complex, coordinated systems marked a significant turning point. Researchers began to explore ways to automate the control of large numbers of devices, integrating features like stealth, resilience, and self-replication into their designs.

One of the pivotal moments in this evolution was the incorporation of automated self-replication. Early botnets were manually controlled and required significant human intervention to manage. However, the introduction of worms—malware that could autonomously spread from one system to another—ushered in a new era. Self-replicating worms demonstrated that malware could spread rapidly and continuously, without direct control from an operator at every stage. This innovation made botnets far more scalable and harder to contain, as the propagation mechanisms exploited inherent vulnerabilities in network protocols and software.

### **The Mirai Botnet and the Rise of IoT Vulnerabilities** {#the-mirai-botnet-and-the-rise-of-iot-vulnerabilities}

A watershed moment in the history of botnets came with the emergence of the Mirai botnet. Mirai was designed to infect Internet of Things (IoT) devices—such as IP cameras, routers, and smart home appliances—that were notoriously undersecured. Its ability to exploit default credentials and inherent vulnerabilities in IoT devices allowed Mirai to amass a network of hundreds of thousands of bots in a relatively short period.

Mirai’s attack in 2016, which harnessed this vast network to launch one of the largest Distributed Denial of Service (DDoS) attacks, brought botnet activity into the mainstream spotlight. The attack underscored how everyday devices, when left unprotected, could be weaponized to disrupt major internet services and infrastructure. It also served as a wake-up call for manufacturers and consumers alike regarding the importance of securing IoT devices.

The fallout from Mirai led to a broader discussion within the cybersecurity community about the need for improved device security protocols, better authentication mechanisms, and continuous monitoring of network behavior. It also inspired subsequent generations of botnets, which sought to overcome the defenses that were rapidly being put in place following the Mirai incident.

### **The Growth of Botnet Capabilities** {#the-growth-of-botnet-capabilities}

Following the Mirai event, botnets continued to evolve in sophistication. Modern botnets now incorporate multiple layers of evasion and resilience, making them formidable adversaries in the cybersecurity landscape. Enhanced command-and-control (C2) architectures allow botmasters to direct their networks in real time, dynamically altering attack strategies based on the defenses they encounter.

Additionally, the integration of peer-to-peer (P2P) communication in some botnets has made centralized shutdown efforts more difficult. In a P2P botnet, every infected device not only receives commands but also relays information to other nodes, thereby decentralizing the control structure. This adaptation has significantly increased the survival rates of botnets when facing targeted takedown operations.

Moreover, botnets have diversified their attack vectors. Beyond the traditional DDoS attacks, they have been harnessed for a range of nefarious activities, including credential harvesting, cryptocurrency mining, and the distribution of more sophisticated malware. At the same time, researchers have turned these capabilities towards ethical research—using controlled botnet simulations to stress-test network defenses and study the dynamics of distributed attacks in safe, sandboxed environments.

### **Security Concerns and the Impact on Cyber Defense** {#security-concerns-and-the-impact-on-cyber-defense}

The historical evolution of botnets has significantly influenced modern cybersecurity strategies. As botnets have grown in scale and complexity, defensive mechanisms have had to evolve correspondingly. Researchers now place considerable emphasis on the development of Intrusion Detection Systems (IDS) and layered security approaches to detect and mitigate botnet-related threats. The continuous arms race between offensive botnet strategies and defensive cybersecurity measures has driven innovation on both sides.

The lessons learned from the history of botnets have also permeated legal and regulatory frameworks. Governments and international bodies have increasingly recognized the need to regulate the security of networked devices, particularly IoT, to mitigate the risk of large-scale botnet attacks. The historical narrative of botnets thus serves not only as a technical case study but also as a catalyst for broader changes in cybersecurity policy and infrastructure resilience.

### **Conclusion** {#conclusion}

From the humble beginnings of scripted experiments to the sprawling, sophisticated networks of today, the history of botnets is a testament to both human ingenuity and the ongoing challenges of securing interconnected systems. Understanding this evolution is crucial for researchers and cybersecurity professionals who seek to develop robust defenses against the ever-evolving landscape of network threats.

## **3. Common Misunderstandings** {#3.-common-misunderstandings}

In the complex world of cybersecurity, several misconceptions have taken root regarding botnets, worms, viruses, and related technologies. Clearing up these misunderstandings is critical not only for accurate academic discourse but also for practical defense strategies. In this section, we aim to debunk common myths and clarify the distinctions between these terms, highlighting how they relate to both malicious activities and ethical research.

### **Distinguishing Between Botnets, Worms, and Viruses** {#distinguishing-between-botnets,-worms,-and-viruses}

A frequent source of confusion arises from the overlapping characteristics of botnets, worms, and viruses. Although these terms are often used interchangeably in popular media, they refer to distinct concepts:

* **Botnets:** At their core, botnets are networks of compromised devices that are controlled remotely by a central entity, known as a botmaster. Their primary function is to execute coordinated commands across a distributed network of infected systems. While botnets often facilitate Distributed Denial of Service (DDoS) attacks and other disruptive activities, they also serve as valuable models for studying distributed systems and network resilience when deployed ethically.

* **Worms:** Worms are standalone programs designed to self-replicate and spread autonomously across networks. They typically exploit system vulnerabilities to propagate without requiring user intervention. Unlike viruses, worms do not need to attach themselves to legitimate programs; their independent replication process often makes them both more efficient and more difficult to contain.

* **Viruses:** Viruses are malicious code that attaches to other executable files or programs, relying on user actions—such as running a program—to spread. Their mode of operation is distinctly different from worms, as they require a host application to function and often aim to corrupt or alter the host’s data.

These distinctions are not merely academic; they form the basis for developing targeted defense mechanisms. For instance, strategies effective against self-replicating worms may not be sufficient to counteract a botnet’s distributed command-and-control operations.

### **Misinterpretation of Botnet Activity: DDoS vs. Botnet Functionality** {#misinterpretation-of-botnet-activity:-ddos-vs.-botnet-functionality}

One pervasive misunderstanding is the belief that all botnets are inherently designed to launch DDoS attacks. In reality, while many high-profile incidents have involved DDoS attacks, the functionality of a botnet is far broader. Botnets can be configured for:

* **Credential Theft:** Stealing login credentials or sensitive information from compromised systems.  
* **Malware Distribution:** Acting as a delivery mechanism for additional payloads, including ransomware.  
* **Spamming and Phishing:** Disseminating unwanted or fraudulent messages across networks.  
* **Cryptocurrency Mining:** Exploiting system resources to mine digital currencies without the owner’s consent.

By acknowledging the versatility of botnets, researchers can better tailor detection methods and develop multifaceted defense strategies that address a wider range of potential threats.

### **The Honeypot Analogy: GIF of a Venus Flytrap** {#the-honeypot-analogy:-gif-of-a-venus-flytrap}

A particularly creative analogy used to explain botnet detection involves the imagery of a Venus Flytrap. Imagine a vibrant, alluring Venus Flytrap that, at first glance, appears benign and attractive. In reality, its purpose is predatory—to capture unsuspecting prey that ventures too close. In a similar fashion, a honeypot is a decoy system specifically designed to lure cyber attackers. Once the attacker interacts with the honeypot, the system can capture detailed data about the attack techniques and behaviors.

In this gif, animated elements mimic the flytrap’s rapid response to prey: as simulated malicious traffic approaches, the animation shows the “trap” closing, symbolizing the IDS (Intrusion Detection System) capturing and isolating suspicious activities. This animated analogy helps to demystify complex detection processes and illustrates the layered defense strategies that are essential in modern cybersecurity.

### **Debunking Myths and Misconceptions** {#debunking-myths-and-misconceptions}

Several myths surrounding botnets persist in both popular culture and within technical communities. Here, we address some of the most common misconceptions:

* **Myth 1: Botnets are solely used for illegal activities.**  
   While it is true that botnets have been exploited for criminal purposes, their underlying technology is also harnessed for legitimate research. Controlled experiments using botnet-like distributed systems can provide insights into network behavior, stress-test infrastructures, and help develop robust cybersecurity protocols.

* **Myth 2: All worms are inherently dangerous.**  
   Worms are often portrayed as purely malicious. However, self-replicating worms created within controlled environments can serve as invaluable research tools. By understanding the propagation mechanisms of worms, researchers can develop more effective countermeasures against their malicious counterparts.

* **Myth 3: DDoS attacks are synonymous with botnet operations.**  
   Although many DDoS attacks are orchestrated using botnets, the two concepts are not identical. A DDoS attack is a specific type of network assault, whereas a botnet is a broader framework that can be utilized for a variety of actions beyond simply overwhelming network traffic.

### **Emphasizing Clarity in Cybersecurity Terminology** {#emphasizing-clarity-in-cybersecurity-terminology}

Establishing clear and consistent terminology is crucial for the field of cybersecurity. Precise definitions enable researchers, practitioners, and policymakers to communicate effectively and collaborate on developing strategies to combat emerging threats. By demystifying these terms and debunking widespread misconceptions, this guide fosters a deeper understanding of both the offensive capabilities and defensive necessities of modern botnet technology.

In summary, the common misunderstandings surrounding botnets, worms, and viruses highlight the need for rigorous education and precise language in cybersecurity. As the digital landscape continues to evolve, it becomes increasingly important for both practitioners and academics to challenge these misconceptions and build a comprehensive, nuanced perspective on the complex interplay between offensive research and defensive strategy.

## **4. Table of Positive and Negative Uses of Botnets** {#4.-table-of-positive-and-negative-uses-of-botnets}

The dual-use nature of botnet technology is one of its most intriguing and complex characteristics. While often associated with illegal activities and cyberattacks, botnets also offer substantial potential when deployed ethically in controlled environments. This section presents a detailed comparison of the positive and negative uses of botnet technology. The table below encapsulates various applications on both sides of the spectrum, illustrating how the same underlying infrastructure can be harnessed for both beneficial and harmful purposes.

On the positive side, botnet frameworks have been repurposed to serve as invaluable tools for research and testing. For instance, they can be used to simulate large-scale network loads, which is crucial for understanding system performance under stress. Ethical honeypot research leverages controlled botnet environments to attract and analyze malicious behavior without causing real harm, thereby enhancing our defensive strategies. Additionally, botnets are applied in AI/ML model training to generate synthetic, distributed data, and in distributed computing to solve complex computational problems. These controlled applications are central to advancing cybersecurity training, IoT security research, and defense simulations, where the goal is to learn from adversarial techniques in a safe manner.

Conversely, when misused, botnets can facilitate a host of malicious activities. DDoS attacks remain one of the most notorious applications, where botnets overwhelm targets with traffic. Other negative uses include credential theft, malware distribution, botnet-for-hire services, and spamming or phishing campaigns. Furthermore, botnets have been exploited for unauthorized cryptocurrency mining, where they commandeer system resources for illicit gain, and for propagating ransomware across networks.

The following table succinctly summarizes these contrasting uses:

| Good and bad uses of Botnets |  |
| ----- | ----- |
|  **Positive Use** |  **Negative Use** |
| Load testing networks | DDoS attacks |
| Ethical honeypot research | Credential theft |
| AI/ML model training | Malware distribution |
| Distributed computing | Botnet-for-hire services |
| Cybersecurity training | Spamming & phishing |
| IoT security research | Cryptocurrency mining |
| Defense simulation | Ransomware propagation |
|

This clear juxtaposition of uses underscores the importance of context and control in deploying botnet technologies. While they hold promise for enhancing our understanding of distributed networks and improving cybersecurity defenses, their misuse can result in significant and widespread harm.

## **5. Mini Implementation of a Malicious Toy Botnet** {#5.-mini-implementation-of-a-malicious-toy-botnet}

This section provides a detailed, step-by-step guide for creating a miniature botnet, strictly for research and educational purposes. In this controlled experiment, the goal is to simulate the behavior of a malicious botnet while ensuring that no harm is done. The implementation focuses on using a network of 5 to 10 virtual machines and developing a basic self-replicating worm with limited replication—capped at 50 iterations. The worm is designed to embed itself in various directories while carrying a benign payload that simply outputs "Hello World."

### **5.1 Overview and Objectives** {#5.1-overview-and-objectives}

Before delving into the technical details, it is important to understand the key objectives of this mini implementation:

* **Controlled Environment:** The experiment is carried out in a secured and isolated network, ensuring that no external systems are affected.  
* **Limited Replication:** The self-replicating worm is programmed to replicate up to 50 times only, to maintain control over the spread.  
* **Stealth Embedding:** The worm will hide itself within less-obvious directories, simulating the concealment tactics often employed by real-world malware.  
* **Harmless Payload:** The final payload, triggered upon successful replication, is entirely harmless—a simple "Hello World" message—demonstrating the replication mechanism without causing damage.

### **5.2 Environment Setup** {#5.2-environment-setup}

For this experiment, an isolated network composed of 5 to 10 virtual machines is set up. Each VM runs in a sandboxed environment, such as a Docker container or an air-gapped virtual machine, to ensure that the implementation remains completely contained. The following measures are taken during the setup:

* **Network Isolation:** The virtual machines are configured on a private network with no external access.  
* **Uniform Configuration:** Each VM has the same operating system and software dependencies installed to maintain consistency across the test environment.  
* **Logging Mechanisms:** A centralized logging server is configured to capture replication events and process logs from each machine.

### **5.3 Design of the Self-Replicating Worm** {#5.3-design-of-the-self-replicating-worm}

The worm’s design consists of three primary components:

1. **Replication Engine:** This module is responsible for copying the worm to new locations. It checks a replication counter to ensure that no more than 50 iterations occur.  
2. **Embedding Module:** The worm uses directory traversal to locate subdirectories where it can hide its code. This stealth feature helps mimic techniques used by more sophisticated malware.  
3. **Payload Execution:** Upon reaching a predefined condition or after a set number of replications, the worm executes its benign payload, printing “Hello World” to confirm its successful spread.

### **5.4 Implementation Details** {#5.4-implementation-details}

Below is a detailed breakdown of the implementation steps along with pseudocode and sample code snippets written in Python. **Note:** This code is for educational purposes only and must be executed only in a controlled, isolated environment.

#### **5.4.1 Initialization and Configuration** {#5.4.1-initialization-and-configuration}

The worm begins by initializing a replication counter and reading a configuration file that determines which directories to target for replication. For demonstration purposes, the configuration is embedded within the code.

```python
import os
import sys
import shutil

# Configuration settings
REPLICATION_LIMIT = 50
TARGET_DIRECTORIES = ['./sandbox1', './sandbox2', './sandbox3']
REPLICATION_COUNTER_FILE = 'replication_count.txt'

def initialize_counter():
    """Initialize or read the replication counter from a file."""
    if not os.path.exists(REPLICATION_COUNTER_FILE):
        with open(REPLICATION_COUNTER_FILE, 'w') as f:
            f.write('0')
        return 0
    else:
        with open(REPLICATION_COUNTER_FILE, 'r') as f:
            count = int(f.read().strip())
        return count

def update_counter(count):
    """Update the replication counter in the file."""
    with open(REPLICATION_COUNTER_FILE, 'w') as f:
        f.write(str(count))
```

#### **5.4.2 The Replication Engine** {#5.4.2-the-replication-engine}

The replication engine checks the current replication count and, if under the limit, copies the worm file to a target directory. Each replication increases the counter.
```python
def replicate(worm_path, target_directory, current_count):
    """
    Replicates the worm to the target directory if the replication limit is not exceeded.
    """
    if current_count >= REPLICATION_LIMIT:
        print("Replication limit reached. Stopping further replication.")
        return current_count

    try:
        # Determine a new file name for the replicated worm
        new_worm_name = f'worm_copy_{current_count + 1}.py'
        target_path = os.path.join(target_directory, new_worm_name)

        # Copy the worm file to the target location
        shutil.copy(worm_path, target_path)
        print(f"Worm replicated to {target_path}")
        return current_count + 1
    except Exception as e:
        print(f"Error during replication: {e}")
        return current_count
```

#### **5.4.3 Hiding the Worm** {#5.4.3-hiding-the-worm}

The worm strategically selects directories to hide itself, emulating common malware hiding techniques. The following function randomly selects one of the target directories.

```python
def choose_target_directory():
    """
    Randomly choose a target directory from the list.
    """
    return random.choice(TARGET_DIRECTORIES)
   ```

#### **5.4.4 Payload Execution** {#5.4.4-payload-execution}

Once the worm has replicated a certain number of times, it executes its benign payload. The payload, in this case, is a simple function that prints "Hello World."

```python
def execute_payload():
    """
    Execute the harmless payload.
    """
    print("Hello World")
```

#### **5.4.5 Main Function** {#5.4.5-main-function}

The main function ties all components together. It initializes the replication counter, checks the replication limit, replicates the worm to new directories, and eventually executes the payload once a set condition is met.

```python
def main():
    worm_path = sys.argv[0]  # Current script file path
    replication_count = initialize_counter()

    # Replicate the worm until the replication limit is reached
    while replication_count < REPLICATION_LIMIT:
        target_directory = choose_target_directory()
        replication_count = replicate(worm_path, target_directory, replication_count)
        update_counter(replication_count)

    # Once replication is complete, execute the payload
    if replication_count >= REPLICATION_LIMIT:
        execute_payload()

if __name__ == '__main__':
    main()
```

### **5.5 Analysis and Monitoring** {#5.5-analysis-and-monitoring}

Throughout the experiment, each replication event is logged to a centralized logging system. This monitoring serves two purposes:

* **Validation:** Confirming that the worm replicates exactly 50 times.  
* **Analysis:** Collecting data on how the replication spreads across the network, which directories are chosen more frequently, and how quickly the replication limit is reached.

Detailed logs are analyzed post-experiment to observe the worm’s propagation behavior. This information is critical for understanding potential vulnerabilities in network security and for refining future detection strategies.

### **5.6 Ethical Considerations and Best Practices** {#5.6-ethical-considerations-and-best-practices}

It is essential to reiterate that this mini implementation is designed solely for educational and research purposes. The following best practices must be observed:

* **Controlled Environment:** Always deploy the botnet simulation in a completely isolated network environment.  
* **Limited Scope:** Ensure that the replication is strictly limited (in this case, 50 iterations) to prevent uncontrolled spread.  
* **Benign Payload:** Use a harmless payload, such as a "Hello World" message, to verify replication without causing damage.  
* **Legal Compliance:** Be fully aware of and comply with all relevant laws and institutional policies regarding cybersecurity research.

### **5.7 Conclusion** {#5.7-conclusion}

The mini implementation of a malicious toy botnet presented in this section provides a hands-on demonstration of the mechanics behind botnet propagation. By deploying the worm in a controlled environment, researchers can observe how self-replication occurs, how stealth techniques are employed, and how payloads can be executed in a benign manner. The insights gained from this exercise are invaluable for developing better detection and mitigation strategies in real-world cybersecurity scenarios.

This controlled experiment not only deepens our understanding of botnet behavior but also reinforces the critical importance of ethical practices in cybersecurity research. By simulating an attack within an isolated environment, we can safely study the propagation dynamics and potential countermeasures without exposing actual systems to risk.

## **6. Deploying the Botnet in Ubuntu 22.04 VM** {#6.-deploying-the-botnet-in-ubuntu-22.04-vm}

Deploying a controlled botnet within a virtualized Ubuntu 22.04 environment is a practical exercise designed for research and educational purposes only. In this section, we provide a comprehensive, step-by-step guide to setting up an Ubuntu 22.04 virtual machine (VM), installing essential dependencies, and orchestrating the controlled deployment of a botnet for experimentation.

### **6.1 Virtual Machine Setup** {#6.1-virtual-machine-setup}

The first phase involves preparing a pristine Ubuntu 22.04 virtual machine. This setup must occur in an isolated environment to prevent any accidental interactions with external networks. Below are the key steps:

1. **Installation of Ubuntu 22.04:**  
    Begin by creating a new VM with Ubuntu 22.04. Ensure that the VM is configured with adequate resources—at least 2 GB of RAM, a dual-core processor, and sufficient disk space (approximately 20 GB minimum) to support the installed dependencies.

2. **Network Isolation:**  
    Configure the network settings of the VM to use a host-only or internal network adapter. This isolates the VM from your primary network and the Internet. For example, if using VirtualBox, select “Internal Network” or “Host-only Adapter” in the network settings.

3. **Snapshot Creation:**  
    Once Ubuntu 22.04 is installed and configured, create a snapshot or backup of the VM. This snapshot serves as a restore point in case any misconfigurations or unintended behavior occur during botnet deployment.

### **6.2 Installing Essential Dependencies** {#6.2-installing-essential-dependencies}

A variety of software packages are necessary to create a controlled botnet environment. The following dependencies form the backbone of our setup:

* **Python:** The scripting language used for automation and botnet control.  
* **Flask:** A lightweight web framework for building control interfaces and monitoring tools.  
* **Docker:** For containerizing botnet nodes and ensuring process isolation.  
* **Redis:** A fast in-memory datastore used for inter-node communication.  
* **SSHD:** To facilitate secure remote command execution between nodes.

Below is a step-by-step command guide to install these components on Ubuntu 22.04:

1. **Update the Package List and Upgrade Existing Packages:**


```bash
sudo apt update && sudo apt upgrade -y
```

**2. Install Python and Flask:**

```bash
sudo apt install -y python3 python3-pip
pip3 install flask
```

**3. Install Docker:**

```bash
sudo apt install -y docker.io
sudo systemctl start docker
sudo systemctl enable docker
```

**4. Install Redis:**

```bash
sudo apt install -y redis-server
sudo systemctl start redis-server
sudo systemctl enable redis-server
```

**5. Install and configure SSHD**

```bash
sudo apt install -y openssh-server
sudo systemctl start ssh
sudo systemctl enable ssh
```

### **6.3 Configuring the Environment** {#6.3-configuring-the-environment}

After installing the necessary dependencies, proper configuration is essential to ensure the botnet operates within a controlled, isolated framework.

1. User Permissions and Security:  
    Ensure that the user running the botnet experiments has the necessary permissions to execute Docker containers and manage network configurations. Add your user to the Docker group if needed:

```bash
sudo usermod -aG docker $USER
```

After executing this command, log out and back in to apply changes.

**Firewall Configuration:**  
 Configure the Uncomplicated Firewall (UFW) to restrict external access. For example, allow only local connections:

```bash
sudo ufw default deny incoming
sudo ufw default allow outgoing
sudo ufw allow ssh
sudo ufw enable
```

**Setting Up a Logging Mechanism:**

Implement a logging solution to capture botnet activity. You can use local logging files or forward logs to a dedicated monitoring tool. For a simple setup, create a centralized log directory:

```bash
mkdir ~/botnet_logs
```

1. Ensure that your Python scripts and Docker containers are configured to write logs to this directory.

### **6.4 Step-by-Step Botnet Deployment** {#6.4-step-by-step-botnet-deployment}

With the VM configured and all dependencies in place, the next stage is deploying the botnet itself. This involves launching a central controller that dispatches commands to individual nodes and orchestrating the replication process.

#### **Step 1: Launching the Botnet Controller** {#step-1:-launching-the-botnet-controller}

Develop a simple Flask application that acts as the central controller for the botnet. This controller will send commands to the individual bot nodes, monitor their status, and record their responses.

**Example Controller (controller.py):**

```python
from flask import Flask, request, jsonify
import redis

app = Flask(__name__)
r = redis.Redis(host='localhost', port=6379, db=0)

@app.route('/send_command', methods=['POST'])
def send_command():
    command = request.json.get('command')
    r.publish('botnet_channel', command)
    return jsonify({'status': 'Command dispatched', 'command': command})

@app.route('/status', methods=['GET'])
def status():
    # For demonstration, a simple status response is returned.
    return jsonify({'status': 'Botnet controller active'})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
```

Launch the controller with the play button in your editor or:

```bash
python3 controller.py 
```

In the terminal.

#### **Step 2: Deploying Botnet Nodes via Docker** {#step-2:-deploying-botnet-nodes-via-docker}

Each botnet node runs within its own Docker container. Create a Dockerfile to containerize the botnet node application. The node listens for commands from Redis and executes the replication or payload operations accordingly.

**Example Dockerfile (Dockerfile):**

```Dockerfile
FROM python:3.9-slim
WORKDIR /app
COPY node.py /app/node.py
RUN pip install redis
CMD ["python", "node.py"]
```

**Example Node Script (node.py):**

```python
import redis
import time

r = redis.Redis(host='host.docker.internal', port=6379, db=0)
pubsub = r.pubsub()
pubsub.subscribe('botnet_channel')

def execute_command(command):
    print(f"Executing command: {command}")
    # Simulated operation: can add replication or payload execution logic here
    if command == "execute_payload":
        print("Hello World")

if __name__ == '__main__':
    print("Botnet node active and awaiting commands.")
    for message in pubsub.listen():
        if message['type'] == 'message':
            command = message['data'].decode('utf-8')
            execute_command(command)
```

**Run the file**

```bash
docker build -t botnet_node .
```

**Deploy the containers:**

```bash
docker run -d --name node1 botnet_node
docker run -d --name node2 botnet_node
docker run -d --name node3 botnet_node
```


#### Step 3: Coordinating Replication and Payload Delivery {#step-3:-coordinating-replication-and-payload-delivery}

With the controller and nodes running, use the Flask controller to dispatch commands. For example, you can simulate replication commands or instruct nodes to execute the payload:

1. Dispatch a Replication Command:  
    Using a tool like cURL or Postman, send a POST request:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"command": "replicate"}' http://localhost:5000/send_command
```
2. Execute the Payload:

Similarly, dispatch the payload execution command:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"command": "execute_payload"}' http://localhost:5000/send_command
```

Each botnet node receives the command via the Redis channel and performs the programmed actions. In our example, when the "execute_payload" command is received, each node prints "Hello World" to its log.

### **6.5 Verification and Monitoring** {#6.5-verification-and-monitoring}

After deploying the botnet, it is essential to verify its operation and monitor its behavior in real time:

* **Logging:**  
   Ensure that all botnet nodes write their output to the centralized log directory. Monitor these logs to verify that replication and payload execution occur as expected.

* **Status Endpoint:**  
   Use the status endpoint of the Flask controller to check if the controller is active. For instance, access http://localhost:5000/status in your web browser.

* **Redis Monitoring:**  
   Utilize Redis commands (e.g., `redis-cli monitor`) to observe the real-time commands being published on the `botnet_channel`.

### **6.6 Best Practices and Final Considerations** {#6.6-best-practices-and-final-considerations}

Deploying a botnet—even in a controlled environment—requires adherence to strict ethical and operational guidelines:

* **Isolation is Key:**  
   Ensure that all experiments remain confined to the VM and isolated network. Never expose these systems to the public Internet.

* **Strict Command Control:**  
   All commands dispatched by the controller must be thoroughly vetted. Implement safeguards to avoid unintended propagation or execution of harmful commands.

* **Documentation and Logging:**  
   Maintain detailed logs of every action taken. These logs are essential for post-experiment analysis and for refining detection and mitigation strategies.

* **Legal and Ethical Compliance:**  
   Always conduct experiments in line with institutional policies and applicable laws. This controlled deployment is for research and educational purposes only and must not be replicated outside a secure environment.

### **6.7 Conclusion** {#6.7-conclusion}

Deploying the botnet within an Ubuntu 22.04 VM involves a multi-layered approach—starting from the installation of a clean, isolated operating system, through the configuration of essential dependencies, to the deployment of a centralized controller and containerized nodes. By following the steps outlined above, researchers can create a robust testbed to study botnet behavior in a controlled setting. This practical deployment serves as a foundational exercise for understanding the intricacies of distributed network attacks, paving the way for advanced research in detection, mitigation, and cybersecurity defense.

## **7. Detecting the Botnet & IDS Animation** {#7.-detecting-the-botnet-&-ids-animation}

Detecting botnet activity in a controlled environment is a crucial step in understanding and mitigating potential cybersecurity threats. In this section, we explore a comprehensive approach to botnet detection that combines traditional Intrusion Detection Systems (IDS) with modern visualization techniques. In particular, we integrate a GIF animation that metaphorically represents the detection process through the imagery of a Venus Flytrap—a natural predator that lures, captures, and analyzes its prey.

### **7.1 Understanding Botnet Detection** {#7.1-understanding-botnet-detection}

Botnets, by their very nature, are distributed networks of compromised devices designed to operate stealthily. Their detection involves identifying subtle anomalies across network traffic and system logs. The following techniques are commonly employed:

* **Traffic Analysis:** Monitoring the volume, frequency, and patterns of network traffic. Sudden surges or consistent patterns of abnormal traffic may indicate botnet activity.  
* **Behavioral Anomaly Detection:** Identifying deviations from normal system behavior, such as unusual CPU usage, abnormal process creation, or irregular system calls.  
* **Signature-Based Detection:** Utilizing a database of known malicious signatures to match against network packets or log entries.  
* **Heuristic and Anomaly-Based Methods:** Employing machine learning and statistical models to identify patterns that deviate from a learned baseline of normal operations.

By combining these methods, cybersecurity professionals can build robust detection mechanisms that not only flag known threats but also highlight new or modified attack patterns that do not match any existing signatures.

### **7.2 Designing the Intrusion Detection System (IDS)** {#7.2-designing-the-intrusion-detection-system-(ids)}

A well-structured IDS is critical for early detection of botnet propagation. The IDS typically consists of several key components:

1. **Data Collection Agents:** These agents are deployed across all nodes in the network to collect data from system logs, network traffic, and other relevant sources.  
2. **Centralized Analysis Engine:** This engine aggregates the data from various agents and applies detection algorithms—such as signature matching and anomaly detection—to identify potential threats.  
3. **Alert and Response Module:** Once a threat is detected, this module issues alerts to network administrators and, if configured, can trigger automated responses such as isolating the affected node or blocking suspicious IP addresses.  
4. **Visualization Dashboard:** A user-friendly interface that displays real-time data and alerts, helping administrators quickly assess the network’s security posture.

For our controlled environment, the IDS is configured to monitor both network traffic (capturing anomalies related to botnet communication) and local logs generated by the deployed nodes.

#### **7.2.1 Implementing the IDS: A Step-by-Step Approach** {#7.2.1-implementing-the-ids:-a-step-by-step-approach}

Below is a high-level overview of the IDS implementation in our botnet simulation:

* **Step 1: Data Collection Setup**  
   Each node in the controlled network is configured with a logging agent. These agents capture key events such as:

  * Connection attempts on unusual ports.  
  * Unexpected spikes in network traffic.  
  * Log entries related to process execution and system changes.  
* For example, a lightweight Python script can be used to tail log files and send data to the central analysis engine via a messaging queue or direct API calls.

* **Step 2: Centralized Analysis with Log Aggregation**  
   Using tools like the ELK (Elasticsearch, Logstash, Kibana) stack, collected logs are indexed and analyzed in real time. Logstash processes incoming data, applying filters and normalizing logs from different sources. Elasticsearch indexes these logs, making them searchable, while Kibana provides visual dashboards to observe trends and anomalies.

* **Step 3: Alerting and Automated Responses**  
   The analysis engine is configured to generate alerts when specific thresholds are exceeded or when known malicious patterns are detected. For example, a sudden spike in replication events or frequent connection requests from multiple nodes could trigger an alert. Alerts can be dispatched via email, SMS, or integrated directly into a network operations center (NOC) dashboard.

* **Step 4: Integration with the Botnet Controller**  
   For our simulation, the IDS is integrated with the botnet controller system. This integration allows the controller to send test commands and receive feedback on whether nodes are acting normally or if suspicious activities are detected. This bidirectional communication is key to fine-tuning both the detection algorithms and the network’s response strategies.

### **7.3 Practical Example: IDS Detection Code** {#7.3-practical-example:-ids-detection-code}

Below is an illustrative Python snippet that demonstrates a simple log monitoring and alerting mechanism. In a real-world scenario, this would be part of a larger system incorporating machine learning models and sophisticated rule sets.

```python
import time
import re
import smtplib
from email.mime.text import MIMEText

# Configuration for log monitoring
LOG_FILE_PATH = '/var/log/botnet_node.log'
ALERT_THRESHOLD = 5  # For example, 5 suspicious events in a given period
CHECK_INTERVAL = 10  # seconds
SUSPICIOUS_PATTERN = r'(replicate|connection_attempt|unauthorized_access)'

# Email configuration for alerts
SMTP_SERVER = 'smtp.example.com'
SMTP_PORT = 587
EMAIL_FROM = 'alert@example.com'
EMAIL_TO = 'admin@example.com'
EMAIL_SUBJECT = 'Botnet Activity Alert'

def send_alert(alert_message):
    msg = MIMEText(alert_message)
    msg['Subject'] = EMAIL_SUBJECT
    msg['From'] = EMAIL_FROM
    msg['To'] = EMAIL_TO
    try:
        with smtplib.SMTP(SMTP_SERVER, SMTP_PORT) as server:
            server.starttls()
            # Assume login credentials are set securely
            server.login('user', 'password')
            server.send_message(msg)
        print("Alert sent successfully.")
    except Exception as e:
        print(f"Failed to send alert: {e}")

def monitor_logs():
    suspicious_count = 0
    last_position = 0

    while True:
        try:
            with open(LOG_FILE_PATH, 'r') as log_file:
                # Seek to last read position
                log_file.seek(last_position)
                lines = log_file.readlines()
                last_position = log_file.tell()

                for line in lines:
                    if re.search(SUSPICIOUS_PATTERN, line):
                        suspicious_count += 1

                if suspicious_count >= ALERT_THRESHOLD:
                    alert_message = f"Detected {suspicious_count} suspicious events in the logs."
                    send_alert(alert_message)
                    suspicious_count = 0  # Reset count after alerting

        except FileNotFoundError:
            print("Log file not found. Waiting for log generation...")
        
        time.sleep(CHECK_INTERVAL)

if __name__ == '__main__':
    monitor_logs()
```

This example continuously monitors a log file for keywords indicative of botnet activity. When the number of suspicious events exceeds a predefined threshold, it sends an alert. In a more complex deployment, similar logic would be integrated into the central analysis engine of the IDS.

### **7.4 Visualizing Detection with GIF Animation** {#7.4-visualizing-detection-with-gsap-animation}

While textual logs and dashboards are crucial, visualizing the detection process can enhance understanding and provide an intuitive grasp of the system's behavior. The GIF animation in our simulation serves as a dynamic representation of how an IDS “captures” botnet activity.

#### **7.4.1 Conceptualizing the Animation** {#7.4.1-conceptualizing-the-animation}

Imagine a vibrant Venus Flytrap in an animated environment. The flytrap, known for its rapid response, represents the IDS. As simulated malicious traffic (represented by moving digital “insects” or data packets) approaches the flytrap, the animation illustrates the following sequence:

1. **Attraction:**  
    The animation begins with an open, inviting Venus Flytrap. Digital particles representing network traffic approach the flytrap in a steady stream.

2. **Detection:**  
    As soon as suspicious particles come within a defined radius, subtle changes occur in the animation—such as the flytrap’s leaves starting to vibrate or change color—indicating that the IDS has detected anomalous activity.

3. **Capture:**  
    In a rapid, fluid motion, the flytrap closes its leaves, effectively “capturing” the suspicious traffic. This is analogous to the IDS triggering an alert and isolating the suspect data.

4. **Analysis and Response:**  
    Once captured, the animation displays a brief analysis sequence (perhaps with visual indicators such as scanning lines or data flowing through a magnifying glass). Finally, the animation might display a clear “Alert” message, mimicking the real-time notifications sent by an IDS.

   ![][image1]  
     
     sadly gifs are not compatible with markdown.  
     
   

## **8. Implementing a Mesh-Based Honeypot (100 Docker Nodes)** 
{#8.-implementing-a-mesh-based-honeypot-(100-docker-nodes)}

In this section, we delve into the design, deployment, and operation of a mesh-based honeypot network consisting of 100 Docker nodes. This large-scale simulation is crafted for research and educational purposes to study real-world attack patterns, honeypot interactions, and the propagation techniques of malicious actors. By creating a controlled, distributed network of honeypots, researchers gain invaluable insights into attacker methodologies, vulnerabilities, and potential defense strategies.

### **8.1 Introduction and Objectives** {#8.1-introduction-and-objectives}

The concept of a honeypot involves setting up decoy systems that mimic real production environments, deliberately configured with vulnerabilities to attract cyber attackers. In a mesh-based honeypot architecture, multiple honeypot nodes work together in a network that simulates a production-scale environment. The objectives of this project are as follows:

* **Detection of Malicious Activities:** Observe and log unauthorized access attempts, exploit techniques, and lateral movements across the network.  
* **Data Collection:** Aggregate rich datasets on attack vectors, intrusion methodologies, and exploitation patterns.  
* **Inter-node Communication:** Use Redis for real-time communication between nodes to correlate attack patterns and share event data.  
* **Centralized Monitoring:** Deploy a Command and Control (C2) server to monitor the status of all nodes, manage configurations, and serve as a central analysis point.  
* **Logging and Visualization:** Utilize the ELK (Elasticsearch, Logstash, Kibana) stack to index, search, and visualize the attack logs in real time.  
* **Resilience Testing:** Analyze how a distributed network behaves under persistent attack scenarios and identify potential improvements in network defenses.

This controlled mesh environment mimics real-world deployments, yet remains safely isolated to ensure no unintended damage occurs. Through this simulation, researchers can test advanced detection techniques, improve incident response strategies, and refine security protocols.

### **8.2 Architectural Overview** {#8.2-architectural-overview}

The mesh-based honeypot architecture is composed of several integrated components:

1. **Docker Nodes as Honeypots:**  
    Each node is containerized using Docker and configured with a honeypot service. In our case, we deploy Cowrie—a popular SSH honeypot—to emulate a vulnerable SSH service that entices attackers.

2. **Inter-node Communication with Redis:**  
    Redis is deployed as a central in-memory datastore facilitating real-time communication between the honeypot nodes. Nodes can publish and subscribe to common channels to share event information and coordinate responses.

3. **Central C2 Server:**  
    A Command and Control server monitors all honeypot nodes. This server aggregates data, sends configuration updates, and triggers alerts when suspicious activities are detected.

4. **ELK Stack Integration:**  
    Attack logs and interaction data from the nodes are forwarded to an ELK stack. Logstash collects and processes the logs, Elasticsearch indexes the data, and Kibana provides a visualization dashboard for real-time analysis.

5. **Network Configuration and Mesh Topology:**  
    The honeypot nodes are deployed across a virtualized network using Docker’s networking features (or optionally, Kubernetes). The mesh topology ensures that nodes are interconnected, allowing attackers to move laterally between honeypots, thereby providing a more realistic simulation of an enterprise network.

   ### **8.3 Environment Setup and Pre-deployment Considerations** {#8.3-environment-setup-and-pre-deployment-considerations}

Before deploying the honeypot mesh, a number of preparatory steps must be taken:

#### **8.3.1 Hardware and Virtualization Requirements** {#8.3.1-hardware-and-virtualization-requirements}

* **Resource Allocation:**  
   Ensure that the host machine or cloud instance has sufficient resources to run 100 Docker containers simultaneously. Recommended specifications include multiple cores (8 or more) and a minimum of 16 GB RAM.

* **Isolation:**  
   The honeypot mesh should be deployed in an isolated network environment. Utilize virtual networks or dedicated VLANs to guarantee that the honeypot traffic does not leak into production networks.

* **Storage and Logging:**  
   Adequate storage must be provisioned to accommodate logs from all nodes. Consider using a centralized logging server that can aggregate data from multiple sources.

  #### **8.3.2 Software Dependencies** {#8.3.2-software-dependencies}

* **Docker Engine:**  
   Install Docker and Docker Compose on the host machine.

* **Cowrie Honeypot:**  
   Cowrie is an SSH and Telnet honeypot that logs brute force attacks and shell interactions. It is available as an open-source project and can be containerized.

* **Redis:**  
   Install Redis as a central communication tool for inter-node messaging.

* **ELK Stack:**  
   Set up Elasticsearch, Logstash, and Kibana on a separate server or container to aggregate and visualize logs.

* **C2 Server Application:**  
   Develop or deploy a lightweight Flask or Node.js application to serve as the Command and Control interface for the honeypot mesh.

  ### **8.4 Detailed Implementation Steps** {#8.4-detailed-implementation-steps}

The implementation of the mesh-based honeypot network can be broken down into several key steps:

#### **8.4.1 Containerizing the Honeypot Nodes** {#8.4.1-containerizing-the-honeypot-nodes}

Each honeypot node is containerized to ensure uniformity and isolation. The following steps outline how to set up a Docker container running Cowrie:

1. **Create a Dockerfile for Cowrie:**

```Dockerfile
# Use a lightweight base image
FROM ubuntu:20.04

# Install dependencies
RUN apt-get update && apt-get install -y 
    git 
    python3 
    python3-pip 
    openssh-server 
    libssl-dev

# Clone Cowrie repository
RUN git clone https://github.com/cowrie/cowrie.git /opt/cowrie

# Set working directory
WORKDIR /opt/cowrie

# Install Python dependencies
RUN pip3 install --upgrade pip && pip3 install -r requirements.txt

# Expose port 2222 for SSH honeypot
EXPOSE 2222

# Start Cowrie
CMD ["python3", "cowrie/src/cowrie.py", "start"]
```

   

This Dockerfile installs the necessary packages, clones the Cowrie repository, installs its Python dependencies, and configures the container to expose the SSH honeypot port.

**Build the Docker Image:**

 Execute the following command to build the image:

```bash
docker build -t cowrie_honeypot . 
```

1. **Configure Container Parameters:**

    Customize Cowrie’s configuration files as needed. Adjust settings such as logging destinations, fake banner messages, and allowed protocols. Ensure that the configuration files are mounted into the container using Docker volumes to allow for dynamic updates.

#### **8.4.2 Deploying 100 Docker Containers** {#8.4.2-deploying-100-docker-containers}

Once the Docker image for the honeypot node is prepared, the next step is to deploy 100 instances of this container. Docker Compose can simplify the orchestration of multiple containers.

1. **Create a Docker Compose File:**

```yaml
version: "3.8"
services:
  cowrie:
    image: cowrie_honeypot
    deploy:
      replicas: 100
    ports:
      - target: 2222
        published: 2222
        protocol: tcp
    environment:
      - NODE_ID=${NODE_ID}
    volumes:
      - ./cowrie_config:/opt/cowrie/etc
    networks:
      - honeynet
networks:
  honeynet:
    driver: overlay
```    

In this Docker Compose file:

* The `replicas` parameter under the deploy section is set to 100, which instructs Docker Swarm (or a compatible orchestrator) to create 100 instances of the Cowrie container.  
* The network configuration uses an overlay network named `honeynet` to interconnect the containers.

**Deploy the Stack:**

 Initialize Docker Swarm (if not already running) and deploy the stack:

```bash
docker swarm init
docker stack deploy -c docker-compose.yml honeypot_mesh 
```


1. This command launches 100 containerized honeypot nodes that will operate in a cohesive mesh network.

#### **8.4.3 Inter-Node Communication with Redis** {#8.4.3-inter-node-communication-with-redis}

Real-time communication between nodes is essential for correlating events and sharing threat intelligence. A Redis instance is set up to serve as the central message broker.

1. **Deploy Redis:**

    Use Docker to deploy a Redis container:

```bash
docker run -d --name redis_server -p 6379:6379 redis:alpine
```

**Configure Honeypot Nodes to Use Redis:**

Modify the Cowrie configuration (or an auxiliary script running within each container) to publish log events and alerts to Redis channels. For example, a Python script running in the background can monitor local logs and publish events:

```python
import redis
import time

redis_client = redis.Redis(host='redis_server', port=6379, db=0)

def publish_event(event_message):
    redis_client.publish('honeypot_events', event_message)

while True:
    # Simulate monitoring log files and detecting an event
    event = "Unauthorized login attempt detected."
    publish_event(event)
    time.sleep(60)
```

1. Ensure that this script is executed as part of the container initialization so that each honeypot node actively reports events.

#### **8.4.4 Setting Up the Command and Control (C2) Server** {#8.4.4-setting-up-the-command-and-control-(c2)-server}

A centralized C2 server aggregates data from the honeypot nodes, provides a control interface, and displays the overall network status. A simple Flask application can serve this purpose.

1. **Develop a Flask C2 Server**

```python
from flask import Flask, jsonify, request
import redis

app = Flask(__name__)
redis_client = redis.Redis(host='redis_server', port=6379, db=0)

@app.route('/status', methods=['GET'])
def status():
    # Retrieve the latest events from Redis or a database
    # For demonstration, returning a static response
    return jsonify({"status": "C2 server active", "nodes": 100})

@app.route('/command', methods=['POST'])
def send_command():
    command = request.json.get("command")
    # Publish the command to all nodes
    redis_client.publish('honeypot_commands', command)
    return jsonify({"status": "Command sent", "command": command})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
```

2. **Deploy the C2 Server:**

 Containerize this application or run it on a dedicated host. The C2 server communicates with the honeypot nodes via the Redis channels and provides an HTTP API for monitoring and control.

#### **8.4.5 Logging and Visualization Using the ELK Stack** {#8.4.5-logging-and-visualization-using-the-elk-stack}

Comprehensive logging is crucial for analyzing attacker behavior. The ELK stack is deployed to collect, index, and visualize logs from all honeypot nodes.

1. **Deploying Elasticsearch:**

```bash
docker run -d --name elasticsearch -p 9200:9200 elasticsearch:7.10.0
```

**Deploying Logstash:**

Create a Logstash configuration file (`logstash.conf`) that listens for log data (e.g., via TCP or file inputs) and forwards it to Elasticsearch:

```javascript
input {
  tcp {
    port => 5000
    codec => json_lines
  }
}

output {
  elasticsearch {
    hosts => ["elasticsearch:9200"]
    index => "honeypot-logs-%{+YYYY.MM.dd}"
  }
}
```

Run Logstash with the configuration:

```bash
docker run -d --name logstash --link elasticsearch -v $(pwd)/logstash.conf:/usr/share/logstash/pipeline/logstash.conf logstash:7.10.0
```

Deploying Kibana:

```bash 
docker run -d --name kibana --link elasticsearch -p 5601:5601 kibana:7.10.0
```

**Configuring Honeypot Nodes to Forward Logs:**

Adjust the Cowrie logging configuration or use an intermediary script to forward logs to Logstash. For example, logs can be sent via TCP to Logstash on port 5000 in JSON format. This centralizes log data from all nodes, allowing analysts to search, filter, and visualize events via Kibana dashboards.

### **8.5 Mesh Topology and Network Considerations** {#8.5-mesh-topology-and-network-considerations}

The mesh-based approach simulates a realistic enterprise network by interconnecting the honeypot nodes. Key considerations include:

* **Overlay Networking:**  
   Utilize Docker’s overlay network driver to create a virtual network that spans multiple hosts (if deploying across a cluster). This ensures that all nodes, regardless of physical location, appear on the same subnet and can communicate freely.

* **Network Segmentation:**  
   For enhanced realism, segment the network into different subnets representing various departments or data centers. Attackers can then be observed moving laterally across segments.

* **Traffic Simulation:**  
   In addition to passive honeypot monitoring, you may simulate legitimate network traffic between nodes. This background traffic helps mask honeypot activity and provides a more challenging environment for attackers.

* **Redundancy and Fault Tolerance:**  
   Design the network to withstand node failures. The distributed architecture ensures that the loss of a few nodes does not compromise overall visibility or the integrity of the mesh.

### **8.6 Security and Ethical Considerations** {#8.6-security-and-ethical-considerations}

Implementing a large-scale honeypot network poses unique security challenges and ethical responsibilities:

* **Isolation:**  
   All honeypot nodes must be deployed in an isolated environment. Prevent any possibility of the honeypot being used as a pivot point into production networks.

* **Data Privacy:**  
   Ensure that data captured by the honeypot is securely stored and access is restricted to authorized researchers. Sensitive information should be anonymized or handled according to ethical guidelines.

* **Legal Compliance:**  
   The deployment and operation of honeypots, even for research purposes, must comply with relevant laws and regulations. Always obtain appropriate permissions and ensure that your research is documented and reviewed by institutional oversight bodies.

* **Controlled Exposure:**  
   While the honeypot must appear vulnerable, it should not be easily misused by external attackers. Limit open ports, monitor outbound traffic, and configure aggressive rate-limiting on exposed services.

### **8.7 Data Analysis and Post-Incident Review** {#8.7-data-analysis-and-post-incident-review}

After deploying the mesh-based honeypot network, the data collected serves multiple research purposes:

* **Attack Pattern Analysis:**  
   With logs centralized in Elasticsearch, researchers can use Kibana to build dashboards that show attack frequency, common exploitation methods, and temporal trends. Visualizations such as heat maps, time series graphs, and flow diagrams help illustrate the behavior of attackers.

* **Intrusion Tactics Correlation:**  
   Inter-node communication via Redis allows for the correlation of events. For example, if multiple nodes report similar intrusion attempts within a short time frame, this pattern can be investigated further to determine if it is part of a coordinated campaign.

* **Threat Intelligence:**  
   The honeypot data may reveal indicators of compromise (IoCs) such as IP addresses, malware signatures, or specific command sequences. This intelligence can be shared (under controlled circumstances) with the broader cybersecurity community to improve collective defenses.

* **Simulation Feedback:**  
   Analyzing the performance of the honeypot network under sustained attack scenarios provides insights into its resilience and potential vulnerabilities. Lessons learned here can inform improvements in both honeypot design and broader cybersecurity strategies.

### **8.8 Challenges and Lessons Learned** {#8.8-challenges-and-lessons-learned}

Deploying a mesh-based honeypot network of this scale is a complex endeavor. Some of the key challenges and corresponding lessons include:

* **Scalability:**  
   Managing 100 nodes requires robust orchestration tools and a careful approach to resource allocation. Docker Swarm and Kubernetes provide the necessary scalability but demand expertise in network configuration and container management.

* **Log Management:**  
   Collecting and analyzing large volumes of log data is resource-intensive. The ELK stack must be appropriately scaled to handle the ingestion rate without performance degradation.

* **False Positives:**  
   In a simulated environment with both honeypot and background traffic, differentiating between genuine attacks and benign anomalies is challenging. Continuous tuning of detection thresholds and heuristic algorithms is required.

* **Interoperability:**  
   Ensuring seamless communication between disparate systems—Cowrie honeypots, Redis messaging, C2 servers, and the ELK stack—requires careful configuration and regular testing to avoid integration issues.

* **Ethical Oversight:**  
   Operating a honeypot network entails ethical responsibilities, including maintaining strict controls over data access and ensuring that the simulated vulnerabilities are not exploited for unintended purposes. A clear ethical framework and oversight are essential.

### **8.9 Future Enhancements and Research Directions** {#8.9-future-enhancements-and-research-directions}

The implementation described here represents a robust starting point for honeypot research. Future enhancements could include:

* **Dynamic Reconfiguration:**  
   Develop mechanisms for dynamic reconfiguration of honeypot nodes based on real-time threat intelligence. This would allow the mesh to adapt to emerging attack patterns and simulate a more responsive network environment.

* **Integration with Machine Learning:**  
   Implement machine learning models to analyze log data and detect subtle, evolving attack patterns that may not trigger traditional threshold-based alerts. Anomaly detection algorithms could continuously learn from new data, improving the system’s accuracy over time.

* **Multi-Protocol Support:**  
   Expand the honeypot services beyond SSH to include HTTP, FTP, and other common protocols. This diversification would provide a more comprehensive picture of attacker strategies and tactics.

* **Geographically Distributed Deployment:**  
   Deploy honeypot nodes across multiple geographic regions (using cloud providers) to study how attack patterns vary based on location. This would add an additional layer of complexity to the mesh network, closely mirroring global enterprise environments.

* **Enhanced Visualization:**  
   Integrate real-time dashboards that combine data from the IDS, C2 server, and ELK stack. Advanced visualization tools can provide a unified view of the entire honeypot mesh, aiding in rapid incident response and comprehensive threat analysis.

### **8.10 Conclusion** {#8.10-conclusion}

Implementing a mesh-based honeypot network comprising 100 Docker nodes offers a unique and powerful research tool for cybersecurity professionals. By creating a realistic, distributed simulation of vulnerable systems, researchers can capture a wealth of data on attacker behavior, test novel detection mechanisms, and refine incident response protocols—all within a strictly controlled environment.

This large-scale deployment involves meticulous planning and execution, from containerizing the Cowrie honeypots and orchestrating their deployment via Docker Swarm, to establishing inter-node communication with Redis and centralizing log data through the ELK stack. The integration of a Command and Control server further enhances the system by providing real-time monitoring and control, ensuring that every aspect of the honeypot mesh is observable and manageable.

The insights garnered from this deployment not only contribute to academic research but also inform practical cybersecurity measures. By understanding how attackers exploit vulnerabilities in a simulated environment, organizations can better prepare for and defend against real-world threats. The lessons learned—from scalability challenges and log management intricacies to the importance of ethical oversight—underscore the need for continuous improvement and innovation in honeypot design.

Ultimately, this mesh-based honeypot network serves as a testament to the value of proactive cybersecurity research. Through controlled experimentation and comprehensive data analysis, we can illuminate the dark corners of attacker behavior, improve our defensive strategies, and drive the evolution of secure, resilient networks.

## **8.5 Using a Layered Architecture to Detect a Botnet** {#8.5-using-a-layered-architecture-to-detect-a-botnet}

### **Introduction** {#introduction}

In today’s threat landscape, the sophistication of botnet attacks requires equally advanced detection methods. A layered detection architecture represents a comprehensive approach to identifying and mitigating botnet activities by integrating multiple security components that work in concert. This strategy—commonly known as defense in depth—ensures that if one security measure is breached or evaded, additional layers continue to provide protection. In this section, we explore how combining multiple detection layers—such as Intrusion Prevention Systems (IPS), firewalls, and Security Information and Event Management (SIEM) tools—creates a resilient security posture. We also examine the benefits of automated blacklisting of botnet Command and Control (C2) servers and compare signature-based detection with anomaly-based detection.

### **The Rationale Behind a Layered Detection Architecture** {#the-rationale-behind-a-layered-detection-architecture}

A layered detection architecture is built on the premise that no single security solution is foolproof. Attackers constantly evolve their techniques, and a single line of defense can often be bypassed by a determined adversary. By deploying multiple, overlapping layers, organizations can:

* **Increase Detection Accuracy:** Multiple systems provide cross-validation. An alert in one layer (e.g., the IPS) can be correlated with data from another layer (e.g., the SIEM) to confirm a threat.  
* **Reduce False Positives:** Integrating diverse detection mechanisms helps distinguish between benign anomalies and genuine threats.  
* **Enhance Response Speed:** Automated coordination between layers enables rapid isolation and remediation of malicious activity.  
* **Improve Resilience:** If one layer fails or is evaded, others remain in place to protect the network.

### **Key Components of the Layered Architecture** {#key-components-of-the-layered-architecture}

#### **1. Intrusion Prevention Systems (IPS)** {#1.-intrusion-prevention-systems-(ips)}

IPS are critical for real-time threat detection and prevention. They analyze network traffic continuously, using both signature-based detection and heuristic methods. An IPS can identify and block known malicious payloads, while also flagging unusual behavior that may indicate a new type of attack.

* **Real-Time Analysis:** IPS inspect packets as they traverse the network, ensuring that any identified threats are immediately blocked.  
* **Adaptive Detection:** By employing heuristic methods, IPS systems can adapt to evolving threats, even those for which no signature exists.  
* **Integration with Other Systems:** When an IPS detects suspicious activity, it can send alerts to SIEM tools, which then provide further context and coordinate a broader response.

#### **2. Firewalls** {#2.-firewalls}

Firewalls serve as the first line of defense by filtering incoming and outgoing network traffic based on predefined security rules. They control the flow of data between trusted and untrusted networks and can block traffic from known malicious IP addresses.

* **Packet Filtering:** Firewalls use both stateless and stateful inspection to determine whether to allow or block traffic.  
* **Traffic Segmentation:** By dividing the network into segments, firewalls prevent lateral movement by attackers within the network.  
* **Initial Barrier:** Acting as the network’s gatekeeper, firewalls reduce the volume of traffic that reaches deeper security layers, thereby lessening the processing load on IPS and SIEM systems.

#### **3. Security Information and Event Management (SIEM) Tools** {#3.-security-information-and-event-management-(siem)-tools}

SIEM systems aggregate logs and event data from various security devices across the network. They correlate disparate data sources to provide a unified view of the security posture.

* **Centralized Data Analysis:** SIEM tools consolidate logs from firewalls, IPS, servers, endpoints, and more, enabling comprehensive threat analysis.  
* **Real-Time Alerting:** By continuously analyzing event data, SIEM systems can generate alerts when suspicious patterns or known threat signatures are detected.  
* **Forensic Capabilities:** SIEM platforms store historical data, allowing security teams to perform forensic analysis post-incident to understand attack vectors and improve defenses.

#### **4. Automated Blacklisting of Botnet C2 Servers** {#4.-automated-blacklisting-of-botnet-c2-servers}

A proactive measure in a layered architecture is the automated blacklisting of known botnet Command and Control servers. This process involves:

* **Threat Intelligence Integration:** Automated systems query real-time threat intelligence feeds to identify IP addresses, domains, or URLs associated with botnet activity.  
* **Dynamic Firewall Updates:** Once a potential C2 server is identified, the system automatically updates firewall rules to block communication with that entity.  
* **Feedback Loops:** Alerts from IPS and SIEM systems can trigger additional blacklisting measures, creating a closed-loop system that continuously refines detection and blocking rules.

#### **5. Signature-Based vs. Anomaly-Based Detection** {#5.-signature-based-vs.-anomaly-based-detection}

A robust layered approach employs both signature-based and anomaly-based detection methods to capture a wide range of threats.

* **Signature-Based Detection:**  
  * **Strengths:** Highly effective against known threats where a precise signature exists.  
  * **Limitations:** Ineffective against new, unknown, or polymorphic attacks that do not match existing signatures.  
* **Anomaly-Based Detection:**  
  * **Strengths:** Capable of identifying zero-day attacks and subtle deviations from normal behavior.  
  * **Limitations:** Tends to generate more false positives since benign deviations can be flagged as suspicious.  
* **Synergistic Operation:**  
   By combining these methods, organizations can benefit from the speed and accuracy of signature-based detection while also capturing novel attack patterns with anomaly-based detection. Data from both methods are integrated into SIEM systems, where further analysis using machine learning algorithms helps reduce false positives and refine detection accuracy.

### **Integrating Detection Layers: A Practical Workflow** {#integrating-detection-layers:-a-practical-workflow}

The integration of these diverse components results in a workflow where data flows seamlessly between layers, ensuring comprehensive coverage and rapid response. Here’s how the workflow typically operates:

1. **Initial Traffic Filtering (Firewalls):**  
   * All incoming and outgoing traffic is first examined by firewalls. Known malicious IP addresses are blocked, and traffic is segmented to minimize lateral movement.  
2. **Real-Time Inspection (IPS):**  
   * Traffic that passes through the firewall is scrutinized by IPS systems. Packets are analyzed in real time, and any packet matching known signatures or exhibiting anomalous behavior triggers an alert.  
3. **Event Correlation (SIEM):**  
   * Alerts from IPS, along with logs from firewalls and endpoints, are aggregated by the SIEM system. Here, data correlation across multiple sources helps verify the threat, reducing the risk of false positives.  
4. **Automated Response (Blacklisting & Alerts):**  
   * If a threat is confirmed, automated systems update firewall rules to block malicious IPs and botnet C2 servers. Simultaneously, alerts are generated and disseminated to security teams for further investigation.  
5. **Continuous Learning and Adaptation:**  
   * Machine learning algorithms analyze historical and real-time data to continuously adjust detection thresholds. This iterative process refines the accuracy of both signature-based and anomaly-based systems over time.

### **Case Study: Coordinated Botnet Detection** {#case-study:-coordinated-botnet-detection}

To illustrate the effectiveness of a layered detection architecture, consider a scenario where an advanced botnet initiates a distributed attack on a corporate network.

#### **Scenario Overview:** {#scenario-overview:}

An attacker launches a coordinated botnet attack using a mix of known and novel techniques. The attack begins with low-level probing across various network segments, followed by bursts of traffic aimed at overwhelming specific servers.

#### **Layered Response:** {#layered-response:}

* **Step 1: Firewall Filtering**

  * The firewall, configured with up-to-date threat intelligence, blocks a number of the attacker's IP addresses based on previous intelligence. However, the attacker employs IP spoofing and uses several unrecognized IP addresses to bypass the firewall.  
* **Step 2: IPS Detection**

  * The IPS detects anomalies in packet behavior, such as rapid-fire connection attempts and unusual protocol usage. It flags these patterns and blocks the immediate offending traffic, while sending detailed alerts to the SIEM system.  
* **Step 3: SIEM Correlation**

  * The SIEM system aggregates alerts from the IPS and cross-references them with logs from other endpoints. Through correlation, it identifies a pattern consistent with a botnet attack, even though individual alerts might have been dismissed as false positives in isolation.  
* **Step 4: Automated Blacklisting**

  * Once the SIEM confirms the coordinated nature of the attack, it triggers an automated process to blacklist the botnet’s C2 server. The firewall and IPS update their rules dynamically, cutting off communication between the compromised devices and the attacker's control center.  
* **Step 5: Continuous Monitoring and Adaptation**

  * The layered system continues to monitor network traffic, adjusting its parameters based on the evolving behavior of the botnet. This ensures that even if the attacker modifies their tactics, the system remains responsive and adaptive.

### **Best Practices for Deploying a Layered Architecture** {#best-practices-for-deploying-a-layered-architecture}

Implementing an effective layered detection system involves more than just deploying the right tools. It requires careful planning, configuration, and continuous monitoring. Here are some best practices to ensure success:

* **Holistic Integration:**

  * Ensure seamless data exchange between firewalls, IPS, SIEM, and automated blacklisting systems. Integration enables real-time correlation and rapid response.  
* **Regular Updates and Patching:**

  * Keep all security systems updated with the latest threat intelligence, software patches, and detection signatures. Regular updates ensure that defenses are effective against the latest threats.  
* **Fine-Tuning Detection Thresholds:**

  * Adjust the sensitivity of anomaly-based systems to balance between detecting threats and minimizing false positives. Feedback from security analysts is crucial in this tuning process.  
* **Comprehensive Logging:**

  * Maintain detailed logs from all security layers. Comprehensive logging facilitates forensic analysis after an incident and helps refine detection mechanisms over time.  
* **Employee Training:**

  * Educate security personnel on the operation and interpretation of alerts generated by the layered system. Human oversight is essential for verifying automated alerts and making informed decisions during incidents.  
* **Continuous Improvement:**

  * Implement a feedback loop where insights from security incidents are used to adjust and improve detection rules, thresholds, and response protocols. Continuous improvement is key to staying ahead of evolving botnet tactics.

### **Future Directions and Innovations** {#future-directions-and-innovations}

As botnet technologies evolve, so must the methods used to detect and neutralize them. Emerging trends and innovations that may further enhance a layered detection architecture include:

* **Advanced Machine Learning and AI:**  
  * Leveraging machine learning algorithms can help predict and identify complex attack patterns, reducing the time between detection and response. AI-driven analytics can further refine detection criteria and minimize false positives.  
* **Integration with Threat Intelligence Platforms:**  
  * Deeper integration with global threat intelligence platforms can ensure that security systems are constantly updated with the latest indicators of compromise, improving the accuracy of automated blacklisting.  
* **Cloud-Native Security Solutions:**  
  * As enterprises increasingly migrate to cloud infrastructures, layered detection architectures will need to evolve to secure dynamic, scalable cloud environments. Solutions that leverage container orchestration and serverless computing will be vital.  
* **Automated Incident Response:**  
  * The next evolution in layered detection may include fully automated incident response systems that not only detect but also immediately remediate threats. Such systems could automatically isolate affected network segments or roll out emergency patches.

### **Conclusion** {#conclusion-1}

A layered architecture for botnet detection provides a robust, comprehensive defense by combining multiple security measures into a cohesive system. By integrating firewalls, IPS, SIEM tools, and automated blacklisting with both signature-based and anomaly-based detection methods, organizations create a resilient, adaptive defense that can quickly identify and mitigate even sophisticated botnet attacks.

This approach ensures that if one layer is compromised, the remaining layers continue to protect the network, thereby reducing the risk and impact of an attack. The synergy between these components enables real-time threat correlation, rapid incident response, and continuous improvement of security measures.

Ultimately, a layered detection architecture is not just a set of tools—it is a strategic framework that embraces defense in depth. It acknowledges that cybersecurity is an ongoing process of adaptation and improvement, one that must evolve in tandem with the threats it faces. By adopting a layered approach, organizations are better equipped to safeguard their networks against the diverse and ever-evolving tactics of botnets, ensuring a more secure and resilient digital environment.

## **9. Capturing and Reverse Engineering the Worm** {#9.-capturing-and-reverse-engineering-the-worm}

Understanding the inner workings of a self-replicating worm is crucial for developing effective countermeasures against botnet propagation. This section outlines a comprehensive process for capturing the worm from honeypot logs and performing a detailed reverse engineering analysis using modern tools such as Redis, Cowrie, ELK, and Ghidra.

### **9.1 Introduction** {#9.1-introduction}

The process of capturing and reverse engineering a worm involves multiple stages: first, collecting the worm’s digital footprint as it propagates through the honeypot network; second, consolidating and sharing events across the network via a central communication channel; third, forwarding detailed honeypot data to an analysis platform; and finally, deconstructing the worm’s binary using reverse engineering tools to understand its structure, behavior, and vulnerabilities. This methodical approach provides deep insights into the mechanisms behind worm replication and paves the way for improved detection and remediation strategies.

### **9.2 Capturing the Worm from Honeypot Logs** {#9.2-capturing-the-worm-from-honeypot-logs}

In a mesh-based honeypot environment, the worm leaves behind a wealth of information as it attempts to replicate and propagate. The first step in analyzing the worm is to extract these traces from the honeypot logs.

#### **9.2.1 Log Collection Strategy** {#9.2.1-log-collection-strategy}

Each honeypot node generates logs detailing system interactions, attempted connections, and replication events. These logs are often stored locally and then forwarded to a centralized logging solution, such as the ELK stack. Key aspects of this strategy include:

* **Centralized Logging:**  
   By funneling log data into Elasticsearch, all events related to the worm’s activity can be aggregated, indexed, and made searchable. This centralization facilitates the detection of patterns across multiple nodes.

* **Timestamp Correlation:**  
   Logs are timestamped to help correlate events across the network. This enables security analysts to trace the worm’s replication timeline and identify the origin and propagation pattern.

* **Event Filtering:**  
   Specific keywords or patterns (e.g., “replicate,” “worm_copy,” “unauthorized execution”) are used to filter out benign entries, isolating events that are indicative of worm activity.

#### **9.2.2 Extracting Relevant Log Data** {#9.2.2-extracting-relevant-log-data}

A typical extraction process might involve running queries on the ELK dashboard to identify replication events. For example, using Kibana, you could search for log entries with the keyword “worm_copy” to isolate replication instances. The following pseudocode illustrates this extraction process:

```python
from elasticsearch import Elasticsearch

# Connect to the Elasticsearch instance
es = Elasticsearch("http://localhost:9200")

# Define the query to filter replication events
query = {
    "query": {
        "match": {
            "message": "worm_copy"
        }
    }
}

# Execute the search query on the honeypot logs index
results = es.search(index="honeypot-logs-*", body=query)
for hit in results['hits']['hits']:
    print(hit['_source']['timestamp'], hit['_source']['message'])
```

This query retrieves all log entries related to worm replication, including timestamps and detailed messages. The extracted data forms the basis for further analysis.

### **9.3 Installing Redis for Event Sharing** {#9.3-installing-redis-for-event-sharing}

For efficient event sharing and real-time analysis, Redis is deployed as a central communication hub. Redis enables honeypot nodes to publish events as soon as they are detected, ensuring that data is available for immediate analysis.

#### **9.3.1 Redis Deployment and Configuration** {#9.3.1-redis-deployment-and-configuration}

Redis should be installed on a secure, isolated server within the research environment. The following steps outline the Redis installation process on an Ubuntu system:

```bash
sudo apt update
sudo apt install redis-server -y
sudo systemctl start redis-server
sudo systemctl enable redis-server
```

Once Redis is installed, configuration files may be edited to set parameters such as memory limits, persistence options, and network settings to optimize performance for real-time event sharing.

#### **9.3.2 Publishing and Subscribing to Event Channels** {#9.3.2-publishing-and-subscribing-to-event-channels}

Honeypot nodes can be configured to publish events to a Redis channel. Below is an example Python script that demonstrates how a honeypot node might publish log events to a Redis channel:

```python
import redis
import time

# Connect to Redis
r = redis.Redis(host='localhost', port=6379, db=0)

def publish_event(event_message):
    r.publish('honeypot_events', event_message)

# Simulate reading from a local log and publishing events
def monitor_and_publish():
    while True:
        # In practice, replace this with actual log reading logic
        event = "worm_copy detected at " + time.strftime("%Y-%m-%d %H:%M:%S")
        publish_event(event)
        time.sleep(30)  # Simulate delay between events

if __name__ == '__main__':
    monitor_and_publish()
```

By ensuring that each honeypot node publishes its events to the shared Redis channel, analysts can receive a real-time feed of all replication activities and other suspicious events across the entire mesh network.

### **9.4 Configuring Cowrie to Forward Honeypot Data to ELK** {#9.4-configuring-cowrie-to-forward-honeypot-data-to-elk}

Cowrie, the SSH honeypot deployed on each node, can be configured to forward captured data to the ELK stack. This setup is crucial for consolidating event logs and analyzing them using powerful search and visualization tools.

#### **9.4.1 Modifying Cowrie Configuration** {#9.4.1-modifying-cowrie-configuration}

Cowrie comes with its own configuration files, which need to be modified to direct logs to Logstash. Typically, this involves specifying a remote logging endpoint in the Cowrie configuration file (`cowrie.cfg` or a similarly named file). For example, you might add:

```bash
[output_logstash]
enabled = true
host = logstash_host
port = 5000
protocol = tcp
```

These settings enable Cowrie to send log data directly to Logstash, which then processes and forwards the data to Elasticsearch.

#### **9.4.2 Testing the Forwarding Mechanism** {#9.4.2-testing-the-forwarding-mechanism}

After configuring Cowrie, it is essential to verify that logs are reaching the ELK stack. You can do this by inspecting the Logstash logs or by querying Elasticsearch through Kibana. Successful transmission of logs will confirm that the data pipeline from the honeypot nodes to the centralized analysis platform is functioning as expected.

### **9.5 Reverse Engineering the Worm Using Ghidra** {#9.5-reverse-engineering-the-worm-using-ghidra}

Once the worm’s code has been captured through comprehensive logging and event sharing, the next step is to reverse engineer the worm to understand its internal structure, replication logic, and payload execution. Ghidra, a powerful open-source reverse engineering tool developed by the NSA, is ideal for this purpose.

#### **9.5.1 Overview of Ghidra** {#9.5.1-overview-of-ghidra}

Ghidra provides a suite of tools for disassembling, decompiling, and analyzing binaries. It supports a variety of file formats and processor architectures, making it versatile for analyzing malware samples. Key features include:

* **Disassembly:** Converting binary code into assembly language for detailed analysis.  
* **Decompilation:** Translating low-level code into a higher-level representation that is easier to understand.  
* **Symbol Analysis:** Automatically identifying functions, variables, and code structures.  
* **Interactive Exploration:** Allowing researchers to annotate and document their findings within the tool.

#### **9.5.2 Preparing the Worm Binary for Analysis** {#9.5.2-preparing-the-worm-binary-for-analysis}

Before importing the worm binary into Ghidra, ensure that the sample is isolated and stored in a secure location. The binary should be accompanied by metadata extracted from the logs, such as replication count, targeted directories, and any identified encryption or obfuscation techniques.

#### **9.5.3 Importing and Analyzing in Ghidra** {#9.5.3-importing-and-analyzing-in-ghidra}

The process of reverse engineering in Ghidra can be broken down into several steps:

1. **Importing the Binary:**

   * Open Ghidra and create a new project.  
   * Import the worm binary by selecting "File > Import File" and follow the prompts to configure the initial analysis options.  
   * Ghidra will prompt you to choose the appropriate processor type and language for the binary. If unsure, refer to the metadata or use automated heuristics provided by Ghidra.  
2. **Initial Analysis:**

   * Once the binary is imported, Ghidra will perform an initial auto-analysis. This phase involves identifying functions, control flow, and potential data structures.  
   * Examine the listing window to review disassembled code and navigate to areas of interest, such as the replication engine and payload routines.  
3. **Function and Data Annotation:**

   * Identify key functions by looking for patterns that resemble self-replication logic. Functions that increment a replication counter, search for target directories, or copy files are of particular interest.  
   * Annotate these functions with comments and rename them to reflect their suspected purpose. For example, a function that checks the replication count might be renamed to `checkReplicationLimit()`.  
   * Similarly, locate the code responsible for embedding the worm into directories and mark these sections for further analysis.  
4. **Decompilation for Clarity:**

   * Use Ghidra’s decompiler to translate assembly code into a more readable pseudo-code format. This higher-level view can reveal complex logic and decision-making processes within the worm.  
   * Compare the decompiled output with the known benign payload (“Hello World”) to understand how the worm differentiates between propagation and payload execution.  
5. **Identifying Obfuscation Techniques:**

   * Many worms incorporate obfuscation or encryption to hinder analysis. Look for anomalies such as encrypted strings or unusual function calls that do not follow standard patterns.  
   * Ghidra’s string search functionality can help isolate suspicious strings. Once identified, follow the code path to determine if decryption routines are present.  
   * If obfuscation is used, document the techniques employed and consider using additional tools or scripts to automate the decryption process.  
6. **Documenting the Findings:**

   * As you analyze the worm, maintain detailed notes on your observations, including function names, identified algorithms, and potential vulnerabilities.  
   * Ghidra allows you to add bookmarks, comments, and annotations directly within the code view, making it easier to reference your findings later.

#### **9.5.4 Example Analysis Walkthrough** {#9.5.4-example-analysis-walkthrough}

Consider a scenario where the worm binary contains a function that initiates self-replication. After identifying this function in Ghidra, you might observe that it performs the following actions:

* Checks the current replication counter stored in an external file.  
* Searches for target directories using a list of predefined paths.  
* Copies its binary into one of these directories with a new filename incorporating the replication count.  
* Increments the counter and logs the event.

Using the decompiler view, the pseudo-code might appear as:

```C
if (replication_count < REPLICATION_LIMIT) {
    target = choose_target_directory();
    new_filename = generate_filename(replication_count + 1);
    copy_file(current_executable, target + "/" + new_filename);
    replication_count++;
    log_event("worm_copy created at " + target);
}
```

This clear representation confirms the behavior observed in the honeypot logs. Further analysis might reveal additional functions that handle payload execution, error handling, and even rudimentary evasion techniques designed to avoid detection by standard antivirus software.

### **9.6 Post-Analysis and Remediation Strategies** {#9.6-post-analysis-and-remediation-strategies}

Once the reverse engineering process is complete, the next step is to synthesize the findings to propose effective remediation strategies. Consider the following aspects:

* **Detection Signatures:**  
   Extract specific code patterns, function signatures, or string constants that can be used to develop detection rules for Intrusion Detection Systems (IDS) and antivirus products.

* **Vulnerability Analysis:**  
   Identify weaknesses in the worm’s code—such as reliance on predictable directory names or simple counter logic—that can be exploited to neutralize its replication process.

* **Behavioral Indicators:**  
   Develop a set of behavioral indicators that describe how the worm interacts with the system. These may include file creation patterns, network communication habits, and error messages that occur during propagation.

* **Mitigation Tactics:**  
   Based on the analysis, propose mitigation tactics that may include patching vulnerable systems, configuring firewalls to block specific replication patterns, or employing sandboxing techniques to contain future outbreaks.

### **9.7 Conclusion** {#9.7-conclusion}

Capturing and reverse engineering the worm is an intricate process that bridges the gap between reactive defense and proactive threat analysis. By extracting detailed logs from a controlled honeypot environment, sharing real-time events via Redis, and forwarding comprehensive data to the ELK stack, researchers can amass a complete picture of the worm’s behavior. Ghidra then serves as a powerful tool to deconstruct the binary, revealing the internal mechanics of self-replication, payload execution, and obfuscation.

The insights gained through this process are invaluable for developing targeted detection signatures, refining incident response strategies, and ultimately enhancing the overall security posture against botnet threats. Through meticulous analysis and documentation, this reverse engineering exercise not only demystifies the workings of a self-replicating worm but also reinforces the importance of ethical research in cybersecurity.

## **10. Positive Use Case: Load Testing a Kubernetes Network** {#10.-positive-use-case:-load-testing-a-kubernetes-network}

In today’s agile IT environments, ensuring that distributed systems such as Kubernetes clusters can handle high volumes of traffic is essential. While botnets are typically associated with malicious activities, the underlying technology of distributed traffic generation can be harnessed ethically for stress testing and performance evaluation. In this section, we explore how a botnet-like framework can be repurposed to simulate large-scale load on a Kubernetes network. This approach helps in understanding performance bottlenecks, validating scalability, and fine-tuning resource allocation in real-world production environments.

### **10.1 Introduction** {#10.1-introduction}

Load testing is a critical component of system reliability engineering. By simulating peak traffic conditions, organizations can proactively identify weak points in their infrastructure and apply optimizations before real users are impacted. Traditionally, load testing involves generating artificial traffic using specialized tools or scripts. In contrast, leveraging a distributed load generation framework inspired by botnet methodologies offers a realistic replication of distributed attacks. This method not only stresses the system under test but also provides insights into how networked applications behave under concurrent, high-intensity loads.

The objective of this positive use case is to employ ethical, controlled techniques to generate distributed traffic across a Kubernetes cluster. This simulation mimics the characteristics of a botnet—without any malicious intent—to evaluate the cluster’s performance, scalability, and resilience.

### **10.2 Background: Distributed Traffic Generation and Load Testing** {#10.2-background:-distributed-traffic-generation-and-load-testing}

Botnets are renowned for their ability to coordinate thousands of devices to launch large-scale Distributed Denial of Service (DDoS) attacks. However, the same principles—parallelism, decentralization, and coordinated execution—can be beneficial when applied to load testing. The key benefits include:

* **Realistic Traffic Simulation:** Distributed agents mimic geographically dispersed user requests, generating realistic network traffic.  
* **Scalability Testing:** A large number of simulated nodes can stress-test the system to observe how it scales under increasing loads.  
* **Fault Tolerance Evaluation:** By analyzing system behavior under heavy traffic, organizations can identify and address points of failure.  
* **Resource Optimization:** Insights gained from load testing inform decisions regarding resource allocation, auto-scaling policies, and architectural optimizations.

### **10.3 Kubernetes Cluster Architecture for Load Testing** {#10.3-kubernetes-cluster-architecture-for-load-testing}

A Kubernetes cluster provides a dynamic, containerized environment ideal for simulating production workloads. For our load testing scenario, the cluster is configured to host multiple applications that mimic real services. The key architectural components include:

* **Control Plane:** Manages the overall state of the cluster, including scheduling and orchestration.  
* **Worker Nodes:** Execute containerized applications and serve incoming requests. These nodes are the primary targets for load generation.  
* **Service Mesh:** Provides a layer of abstraction for managing network traffic, service discovery, and inter-service communication.  
* **Ingress Controller:** Acts as the entry point for external traffic, distributing requests among the appropriate services.  
* **Monitoring and Logging Stack:** Tools like Prometheus, Grafana, and ELK stack capture metrics and logs to provide real-time insights into cluster performance.

### **10.4 Implementing Botnet-Like Distributed Traffic Generation** {#10.4-implementing-botnet-like-distributed-traffic-generation}

The strategy involves deploying a set of distributed agents that generate synthetic load, simulating traffic similar to that of a botnet. However, unlike malicious botnets, this setup is entirely controlled and operates within predefined parameters to ensure it does not disrupt production environments.

#### **Key Components of the Load Generation Framework:** {#key-components-of-the-load-generation-framework:}

* **Distributed Agents:** Lightweight, containerized applications running on multiple nodes that generate HTTP/S requests, simulate API calls, or mimic user interactions.  
* **Central Controller:** A management interface that orchestrates the distribution of load, schedules test scenarios, and aggregates performance metrics.  
* **Traffic Patterns:** Configurable patterns that simulate various user behaviors, such as constant request rates, sudden surges (spikes), or gradual ramp-ups.  
* **Feedback Loop:** Integration with the monitoring stack to adjust load dynamically based on real-time performance data.

### **10.5 Step-by-Step Deployment Process** {#10.5-step-by-step-deployment-process}

#### **10.5.1 Setting Up the Kubernetes Cluster** {#10.5.1-setting-up-the-kubernetes-cluster}

1. **Cluster Provisioning:**  
    Deploy a Kubernetes cluster using cloud providers (e.g., AWS EKS, Google Kubernetes Engine, or Azure AKS) or on-premises solutions. Ensure that the cluster is properly isolated for testing purposes.

2. **Node Configuration:**  
    Allocate sufficient resources across the nodes. It is recommended to use autoscaling to simulate realistic load conditions where nodes can be dynamically added or removed.

3. **Deploy Core Services:**  
    Install the necessary services such as an Ingress Controller, service mesh (e.g., Istio), and a centralized monitoring stack (Prometheus, Grafana).

#### **10.5.2 Deploying the Load Generation Agents** {#10.5.2-deploying-the-load-generation-agents}

1. **Containerizing the Agents:**  
    Develop a lightweight load generator using Python or Go. The agents should be containerized using Docker. Below is an example Dockerfile for a simple load generator:

```Dockerfile
FROM python:3.9-slim
WORKDIR /app
COPY requirements.txt .
RUN pip install -r requirements.txt
COPY load_agent.py .
CMD ["python", "load_agent.py"]
```

   

   2. Agent Script Example (`load_agent.py`):

```python
import requests
import time
import random

TARGET_URL = "http://your-ingress-controller-service"

def generate_load():
    while True:
        # Simulate varying load by random sleep intervals
        time.sleep(random.uniform(0.1, 1.0))
        try:
            response = requests.get(TARGET_URL)
            print(f"Response Code: {response.status_code}")
        except Exception as e:
            print(f"Error: {e}")

if __name__ == '__main__':
    generate_load()
```   

   **3. Deploying via Kubernetes Deployment:**

   Create a Kubernetes Deployment manifest that specifies a high replica count for the load generator agents. For example:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: load-generator
spec:
  replicas: 100
  selector:
    matchLabels:
      app: load-generator
  template:
    metadata:
      labels:
        app: load-generator
    spec:
      containers:
      - name: load-agent
        image: your-docker-registry/load-generator:latest
        resources:
          limits:
            cpu: "100m"
            memory: "128Mi"
          requests:
            cpu: "50m"
            memory: "64Mi"
```
   

1. **Deploy the Agents:**  
    Use `kubectl apply -f deployment.yaml` to deploy the agents into your cluster.

   #### **10.5.3 Coordinating Load via a Central Controller** {#10.5.3-coordinating-load-via-a-central-controller}

1. **Central Controller Setup:**  
    Develop a web-based dashboard (using Flask, Node.js, or similar) that allows you to initiate and stop load tests, adjust traffic parameters, and view real-time metrics.

2. **Integration with Monitoring:**  
    The controller should communicate with the monitoring stack (Prometheus) to gather metrics such as response times, error rates, and resource utilization. This data can be displayed on the dashboard for live analysis.

3. **Orchestration of Test Scenarios:**  
    Define multiple test scenarios (e.g., ramp-up tests, sustained load tests, and burst tests) that the controller can trigger. Each scenario will adjust the number of active agents and their request frequency.

   ### **10.6 Performance Analysis and Metrics** {#10.6-performance-analysis-and-metrics}

Once the load generation framework is active, the following key performance metrics should be monitored:

* **Response Time:**  
   Measure the latency experienced by each request. Analyze trends over time to identify potential bottlenecks.

* **Throughput:**  
   Monitor the number of requests processed per second. This metric is crucial to understand the cluster’s capacity under high load.

* **Error Rate:**  
   Track the percentage of requests that fail or return error codes. A high error rate can indicate issues with service availability or resource saturation.

* **Resource Utilization:**  
   Collect metrics on CPU, memory, and network usage from each node. This data helps in understanding how the load impacts system resources and whether autoscaling policies are effective.

* **Auto-Scaling Behavior:**  
   Evaluate how quickly and effectively the Kubernetes autoscaler reacts to increasing load. Metrics such as time to scale and the number of nodes added provide insight into the scalability of the cluster.

Data collected from these metrics should be visualized using dashboards in Grafana or Kibana. Correlating these metrics with the load patterns helps in identifying the thresholds at which the system begins to degrade.

### **10.7 Challenges and Lessons Learned** {#10.7-challenges-and-lessons-learned}

Implementing a distributed load testing framework using botnet-inspired techniques comes with its challenges:

* **Network Overhead:**  
   Generating high volumes of traffic from numerous agents may introduce additional network overhead. It is important to ensure that the load generator itself does not become a bottleneck.

* **Resource Contention:**  
   The Kubernetes cluster must be appropriately sized to handle both the target applications and the load generators. Resource contention can skew performance metrics.

* **Realistic Traffic Patterns:**  
   While the load generators simulate user requests, crafting realistic traffic patterns that accurately mimic production behavior requires careful planning and tuning.

* **Monitoring Complexity:**  
   Aggregating and correlating metrics from a distributed system is inherently complex. Ensuring that the monitoring stack is robust enough to handle the influx of data is crucial.

* **Balancing Test Intensity:**  
   It is essential to calibrate the load to avoid overwhelming the system entirely, which might lead to false negatives in performance evaluation. The goal is to stress-test while still gathering actionable performance data.

Lessons learned from deploying this framework include the importance of iterative testing, continuous monitoring, and proactive scaling. Frequent calibration of load parameters and fine-tuning of autoscaling policies can significantly improve the reliability of the test results.

### **10.8 Conclusion** {#10.8-conclusion}

Repurposing botnet-like distributed traffic generation for load testing Kubernetes networks offers a powerful method for validating system performance under stress. This positive use case demonstrates that the underlying principles of distributed control and coordinated execution can be ethically applied to evaluate and optimize production environments. By deploying a Kubernetes cluster equipped with a robust monitoring stack and a distributed set of load generators, organizations can simulate realistic, high-intensity traffic scenarios that reveal performance bottlenecks and scalability issues.

The approach described in this section encompasses the full lifecycle of load testing—from cluster provisioning and agent deployment to performance analysis and iterative optimization. Not only does this methodology provide valuable insights into how Kubernetes clusters respond to peak loads, but it also informs better resource allocation and auto-scaling strategies. Ultimately, the lessons learned from such comprehensive load tests contribute to building more resilient and responsive cloud-native applications.

Through the controlled use of ethically deployed, botnet-inspired load generators, organizations are empowered to push their systems to the limits in a safe, structured environment. This proactive stance on performance testing is critical in today’s fast-paced, high-availability landscape, ensuring that infrastructures can adapt to growing demands and maintain optimal performance even under the most challenging conditions.

## **11. Conclusion** {#11.-conclusion}

In this comprehensive guide, we have explored the multifaceted world of botnets—from their historical evolution and technical underpinnings to their controlled deployment and ethical applications in cybersecurity research. The document has taken us on a detailed journey, beginning with fundamental definitions and progressing through complex implementations and advanced detection methodologies. Here, we summarize the key takeaways and reflect on the broader implications of this research.

### **Recap of Key Themes** {#recap-of-key-themes}

Throughout this guide, we examined how botnets and self-replicating worms operate as both potential threats and powerful research tools. The historical overview highlighted how early experiments evolved into sophisticated networks capable of coordinating massive Distributed Denial of Service (DDoS) attacks, as exemplified by incidents like the Mirai botnet. Despite their notoriety, the underlying technology offers significant opportunities for ethical experimentation and defense training when deployed in isolated, controlled environments.

A recurring theme in our discussion is the dual-use nature of botnet technologies. On one hand, they are used by malicious actors to conduct large-scale attacks, credential theft, malware distribution, and other illegal activities. On the other hand, controlled experiments—such as the mini implementation of a toy botnet and the deployment of a mesh-based honeypot network—demonstrate how these techniques can be repurposed for load testing, threat analysis, and cybersecurity training. This duality underscores the importance of a strict ethical framework and adherence to legal guidelines when conducting such research.

### **The Importance of a Layered Approach** {#the-importance-of-a-layered-approach}

Our exploration of detection strategies emphasized the value of a layered security architecture. By integrating firewalls, Intrusion Prevention Systems (IPS), Security Information and Event Management (SIEM) tools, and automated blacklisting, researchers and practitioners can develop robust defenses capable of identifying and mitigating even the most sophisticated botnet attacks. This defense-in-depth strategy not only improves detection accuracy but also minimizes false positives and ensures rapid incident response.

### **Practical Implementation and Future Directions** {#practical-implementation-and-future-directions}

The document detailed several practical implementations—from deploying a controlled botnet in an Ubuntu 22.04 VM to creating a distributed honeypot mesh with 100 Docker nodes. These hands-on experiments provide invaluable insights into the replication dynamics, stealth techniques, and payload execution mechanisms of botnets. Furthermore, the positive use case for load testing a Kubernetes network illustrates how these techniques can be harnessed to optimize and validate the performance of modern, scalable systems.

Looking forward, continuous research and innovation in the fields of machine learning, automated incident response, and cloud-native security are essential. As attackers evolve, so must our defensive strategies. The lessons learned from these controlled experiments are critical for informing future cybersecurity policies and technological advancements.

### **Final Reflections** {#final-reflections}

Ultimately, this guide serves as a comprehensive resource for both academic inquiry and practical application in cybersecurity research. It reinforces that while botnet technologies can be extremely dangerous when misused, their controlled study is vital for developing resilient security systems. By fostering a deeper understanding of botnet mechanisms and ethical research practices, we empower cybersecurity professionals to design more effective countermeasures and contribute to a safer digital landscape.

---

## **Appendix A: Glossary of Terms** {#appendix-a:-glossary-of-terms}

* **Botnet:**  
   A network of compromised devices that are remotely controlled by an attacker. Botnets can be used for various purposes—from launching Distributed Denial of Service (DDoS) attacks to facilitating large-scale data breaches.

* **Command and Control (C2):**  
   The infrastructure and communication channels used by a botmaster to issue commands to and manage infected devices within a botnet.

* **IoT (Internet of Things):**  
   A network of interconnected devices—from smart home appliances to industrial sensors—that often have limited security measures, making them attractive targets for botnet recruitment and exploitation.

* **Self-replicating Worm:**  
   A type of malware designed to autonomously duplicate itself across networks, exploiting vulnerabilities to spread rapidly without requiring user interaction.

* **Honeypot:**  
   A decoy system intentionally set up with vulnerabilities to lure attackers. Honeypots are used to capture attack methods, analyze adversarial behavior, and gather intelligence for strengthening cybersecurity defenses.

* **Intrusion Detection System (IDS):**  
   A security tool that monitors network traffic and system activities to identify and alert on malicious behavior or policy violations. IDS solutions can employ signature-based, anomaly-based, or hybrid detection methods.

* **Redis, Cowrie, ELK Stack:**

  * **Redis:** An in-memory data store used for high-speed communication between distributed systems and applications.  
  * **Cowrie:** A popular SSH honeypot that emulates vulnerable services to attract attackers and capture their interaction logs.  
  * **ELK Stack:** A combination of Elasticsearch, Logstash, and Kibana used for aggregating, processing, indexing, and visualizing log data from various sources, providing powerful insights into network security events.

  ## **Appendix B: References and Citations** {#appendix-b:-references-and-citations}

* **Mirai Botnet Analysis:**  
   Comprehensive studies and technical analyses detailing the architecture, propagation, and impact of the Mirai botnet, which exploited IoT vulnerabilities to orchestrate one of the largest DDoS attacks in history.

* **Cybersecurity Whitepapers:**  
   Peer-reviewed research papers and industry reports that delve into modern cybersecurity challenges, emerging threats, and innovative defense strategies. These documents serve as foundational resources for both academic study and practical implementation of security measures.

* **Botnet Countermeasure Research:**  
   A collection of academic and industry research focused on detecting, mitigating, and preventing botnet operations. This research provides critical insights into effective countermeasures, including advanced detection techniques and defensive architectures.

Antonakakis, M., April, T., Bailey, M., Bernhard, M., Bursztein, E., Cochran, J., … & Zhou, Y. (2017).  
 *Understanding the Mirai botnet*. In *26th USENIX Security Symposium (USENIX Security 17)* (pp. 1093–1110). USENIX Association.

Cowrie. (2021).  
 *Cowrie SSH honeypot*. Retrieved from [https://github.com/cowrie/cowrie](https://github.com/cowrie/cowrie)

Elastic. (2021).  
 *The Elastic Stack*. Retrieved from [https://www.elastic.co/what-is/elk-stack](https://www.elastic.co/what-is/elk-stack)

Gu, G., & Qu, L. (2010).  
 *Botnet detection and defense mechanisms: A comprehensive survey*. Journal of Network and Computer Applications, 33(3), 382–392.

Kharraz, A., Kirda, E., & Cristofaro, M. (2012).  
 *UNVEIL: A comprehensive approach to botnet detection*. In Proceedings of the IEEE Symposium on Security and Privacy (pp. 293–307).

Kolias, C., Kambourakis, G., Stavrou, A., & Gritzalis, D. (2017).  
 *DDoS in the IoT: Mirai and other botnets*. Computer, 50(7), 80–84. https://doi.org/10.1109/MC.2017.275

National Security Agency. (2021).  
 *Ghidra software reverse engineering framework*. Retrieved from [https://ghidra-sre.org](https://ghidra-sre.org)

Redis Labs. (2021).  
 *Redis documentation*. Retrieved from https://redis.io/documentation

Stover, S., Jones, K., & Carter, R. (2012).  
 *Botnet detection: Techniques, tools, and challenges*. Journal of Information Security, 3(4), 259–270.

Symantec Corporation. (2020).  
 *Internet Security Threat Report*. Symantec Corporation.

Verizon. (2021).  
 *2021 Data Breach Investigations Report*. Verizon.

---

[image1]: <data:image/png;base64,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>