###  conteneurisation des microservices dans Docker avec Consul



https://github.com/DARR3NG/microservices-consul/assets/127052543/556cb645-8640-4bc0-854c-bfb8140f790e


### Comparaison de Spring Cloud avec Eureka

Je pense que Consul.io excelle dans les domaines suivants :

1. **Focus sur la configuration scriptable pour une meilleure gestion des conteneurs :**
   - Eureka nécessite soit un serveur de configuration externe, soit plusieurs fichiers de configuration.

2. **Options de sécurisation des communications plus avancées :**
   - Eureka nécessite la création d'une application avec les paramètres de sécurité souhaités. La configuration par défaut autorise uniquement HTTP, mais il est possible de forcer HTTPS avec du code.

3. **Prise en charge des points de terminaison non-REST via DNS :**
   - Eureka le ferait probablement via ZUUL et/ou Sidecar.

### Consul vs Eureka

**Eureka :**
- AP (cohérence faible), l'état est répliqué avec "meilleur effort".
- Les services sont enregistrés auprès d'un serveur qui tente de se répliquer sur d'autres serveurs.
- Les enregistrements de services ont une durée de vie, et les clients doivent envoyer des "heartbeat".
- Les lectures sont routées vers n'importe quel serveur, peuvent être obsolètes ou manquantes.
- Évolue bien en raison d'une faible coordination, surtout lorsque les défaillances du serveur sont relativement rares.
- Échoue si tous les serveurs sont hors service.

**Consul :**
- CP (cohérence forte), l'état est répliqué en utilisant Raft.
- Les services sont enregistrés auprès de n'importe quel serveur, mais écrits via Raft à un quorum.
- Les enregistrements ont des vérifications de santé complexes, y compris la détection d'échec par gossip au lieu des "heartbeats".
- Les lectures sont routées vers n'importe quel serveur, consistentes par défaut, mais des lectures obsolètes peuvent être demandées.
- Les lectures obsolètes sont bien évoluées, les lectures cohérentes montent jusqu'à des dizaines de milliers par seconde.
- La cohérence offre le verrouillage et la coordination des clusters.
- De nombreuses fonctionnalités supplémentaires (vérification de santé, verrouillage, KV, fédération, ACL).
- Échoue si la majorité des serveurs sont hors service.

