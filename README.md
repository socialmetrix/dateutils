# Date Utils Converter

Useful to calculate the **week of year** or the **date to week**:

1- Download [dateutils.jar](http://socialmetrix.github.io/dateutils/dateutils.jar) here

2- Save to a know location, ie: `mkdir $HOME/.utils/`

3-  Add this lines to your ~/.bashrc

```shell
alias w2d='java -cp $HOME/.utils/dateutils.jar Week2Date'
alias d2w='java -cp $HOME/.utils/dateutils.jar Date2Week'
```

4- Reload the bashrc and you're good to go!

```shell
$ source ~/.bashrc

$ w2d 2014w30
2014w30       2014-07-21T00:00:00.000Z       2014-07-27T23:59:59.000Z

$ d2w 2014-07-21
2014-07-21       2014w30
```
