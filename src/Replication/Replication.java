package Replication;

import com.basho.riak.client.*;
import com.basho.riak.client.bucket.Bucket;
import com.basho.riak.client.cap.Quora;
import com.basho.riak.client.operations.StoreObject;


/**
 * Created by luthfi on 11/2/2015.
 */
public class Replication {
    public static void main (String args[]) throws RiakException {

        IRiakClient riakClient = RiakFactory.pbcClient("167.205.33.191", 8087);
        Bucket myBucket = riakClient.fetchBucket("cekW").execute();
        StoreObject<IRiakObject> storeObject = myBucket.store("keyW", "Halo semua");
        storeObject.w(0).execute();
        System.out.println(myBucket.fetch("keyW").execute().getValueAsString());
        riakClient.shutdown();
    }
}
