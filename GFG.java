int x=a;

        int ctr = 0;
        byte[] binA=new byte[31];
        byte aOneCount = 0;
        for(int i = a; i>0;i=i/2){
            byte rem = (byte)(i%2);
            if(rem==1)
                aOneCount++;
            binA[ctr++]=rem;
        }
        System.out.println(" A 1s count "+aOneCount);
        for(int i =0;i<binA.length;i++)
            System.out.print(binA[i]+" ");

        System.out.println();
        ctr = 0;
        byte[] binB=new byte[31];
        byte bOneCount = 0;
        for(int i = b; i>0;i=i/2){
            byte rem = (byte)(i%2);
            if(rem==1)
                bOneCount++;
            binB[ctr++]=rem;
        }
        System.out.println(" B 1s count "+bOneCount);
        for(int i =0;i<binB.length;i++)
            System.out.print(binB[i]+" ");
        System.out.println();
        int diff = aOneCount-bOneCount;
        if(diff==0)
            x=a;
        else if(diff>0){
            System.out.println("A > B "+aOneCount+" "+bOneCount);
            for(int i =30;i>=0;i--){
                if(bOneCount==0)
                    binA[i]=0;
                else {
                    if (binA[i] == 1)
                        bOneCount--;
                }
            }
            x = getInt(binA);
        }else{
            diff=diff*-1;
            System.out.println("A < B "+aOneCount+" "+bOneCount);
            for(int i=0;i<31;i++){
                if(diff==0)
                    break;
                if(binA[i]==0){
                    binA[i]=1;
                    diff--;
                }
            }
            x=getInt(binA);
        }
        return x;
