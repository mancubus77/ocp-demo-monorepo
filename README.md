### Deployment
Create new namespce
```
oc new-project monorepo
```

apply ACM manifest file 
```
oc apply -n monorepo -f https://raw.githubusercontent.com/mancubus77/ocp-demo-monorepo/acm/open-cluster-management.yaml
```

