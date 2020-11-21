# *Технологии разработки программного обеспечения*
## *Лабораторная работа №2: создание кластера Kubernetes и деплой приложения*
### *Лебедев Владимир Владимирович ЗМАС2031*
### *Цель лабораторной работы:*

Знакомство с кластерной архитектурой на примере Kubernetes, а также деплоем приложения в кластер.
Развернуть кластер Kubernetes на локальной рабочей станции посредством MiniKube.

### *Инструкция по использованию*

---

Для примения манифестов deployment.yaml и service.yaml, выполните  команду:
 
 
  `kubectl apply -f .`

## service.yaml

```
apiVersion: v1
kind: Service
metadata:
  name: myspring
spec:
  type: NodePort
  ports:
    - nodePort: 31317
      port: 8080
      protocol: TCP
      targetPort: 8080
  selector:
    app: myspring

```

## deployment.yaml

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: myspring
spec:
  replicas: 10
  selector:
    matchLabels:
      app: myspring
  strategy:
    rollingUpdate:
      maxSurge: 1
      maxUnavailable: 1
    type: RollingUpdate
  template:
    metadata:
      labels:
        app: myspring
    spec:
      containers:
        - image: andreas111/myspring
          imagePullPolicy: Never
          name: myspring
          ports:
            - containerPort: 8080
      hostAliases:
        - ip: "192.168.49.2" # The IP of localhost from MiniKube
          hostnames:
          - postgres.local

   
          
```

## Проверить  количество подов можно с помощью команды:

   `kubectl get po`
    
 [Скриншот вывода команды консоли](https://github.com/vovan13347/lab/tree/main/kuberneteslab/pods.jpg)

## Осмотр подов в графическом интерфейсе:

[Скриншот графического интерфейса с подами](https://github.com/vovan13347/lab/tree/main/kuberneteslab/podslistgraph.jpg)







